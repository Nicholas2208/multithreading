package com.nwhite.multithreading.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableExample {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 6; i++) {
            executorService.submit(() -> {
                String threadName = Thread.currentThread().getName();
                int newValueOfCounter = atomicInteger.incrementAndGet();
                System.out.println(threadName + " incremented the value of counter to " + newValueOfCounter);
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("The value of counter: " + atomicInteger.get());
    }
}
