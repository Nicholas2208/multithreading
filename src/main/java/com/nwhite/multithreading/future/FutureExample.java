package com.nwhite.multithreading.future;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FutureExample {

    /*
     * Посчитать сумму элементов списка (более 1 млн элементов),
     * используя для этого 10 потоков
     */
    public static long sum(List<Long> numbers) {
        final int threads = 10;
        List<List<Long>> sublists = split(numbers, threads);

        // TODO: make it work

        return 0;
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
