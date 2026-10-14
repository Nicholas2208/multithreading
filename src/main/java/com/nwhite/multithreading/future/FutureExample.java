package com.nwhite.multithreading.future;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

    /*
     * Посчитать сумму элементов списка (более 1 млн элементов),
     * используя для этого 10 потоков
     */
    public static long sum(List<Long> numbers) {
        final int threads = 10;
        List<List<Long>> sublists = split(numbers, threads);

        ExecutorService executor = Executors.newFixedThreadPool(threads);

        try {
            List<Future<Long>> futures = new ArrayList<>(threads);

            for (List<Long> sublist : sublists) {
                final List<Long> part = sublist;
                futures.add(executor.submit(() -> {
                    long localSum = 0L;
                    for (Long value : part) {
                        localSum += value;
                    }
                    return localSum;
                }));
            }

            long total = 0L;
            for (Future<Long> future : futures) {
                try {
                    total += future.get();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Interrupted while summing", e);
                } catch (ExecutionException e) {
                    throw new RuntimeException("Failed to compute sum", e.getCause());
                }
            }
            return total;
        } finally {
            executor.shutdown();
        }
    }

    private static List<List<Long>> split(List<Long> numbers, int parts) {
        int size = numbers.size();
        int sublistSize = (int) Math.ceil((double) size / parts);

        List<List<Long>> result = new ArrayList<>(parts);
        for (int i = 0; i < parts; i++) {
            int fromIndex = i * sublistSize;
            if (fromIndex >= size) {
                result.add(Collections.emptyList());
            } else {
                int toIndex = Math.min((i + 1) * sublistSize, size);
                List<Long> sublist = numbers.subList(fromIndex, toIndex);
                result.add(sublist);
            }
        }
        return result;
    }
}
