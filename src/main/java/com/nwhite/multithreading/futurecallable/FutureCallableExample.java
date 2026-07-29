package com.nwhite.multithreading.futurecallable;

import java.util.concurrent.*;

public class FutureCallableExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<Integer> task1 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is calculating the square of 5");
            Thread.sleep(2000L);
            return 5*5;
        };

        Callable<Integer> task2 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is calculating the square of 7");
            Thread.sleep(2000L);
            return 7*7;
        };

        Callable<Integer> task3 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is calculating the square of 10");
            Thread.sleep(2000L);
            return 10*10;
        };

        Future<Integer> result1 = executor.submit(task1);
        Future<Integer> result2 = executor.submit(task2);
        Future<Integer> result3 = executor.submit(task3);

        try {
            System.out.println("Square of 5: " + result1.get());
            System.out.println("Square of 7: " + result2.get());
            System.out.println("Square of 10: " + result3.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
    }
}
