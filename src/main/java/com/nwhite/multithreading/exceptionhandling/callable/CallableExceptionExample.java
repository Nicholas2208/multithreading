package com.nwhite.multithreading.exceptionhandling.callable;

import java.util.concurrent.*;

public class CallableExceptionExample {

    public static void main(String[] args) {
        while (true) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
//        Callable<String> task = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return null;
//            }
//        };

            Callable<String> task = () -> {
                System.out.println(Thread.currentThread().getName() + ": task started");
                double value = Math.random();
                System.out.println("Generated number for thread" +
                        Thread.currentThread().getName() +
                        " is " + value);
                if (value > 0.5) {
                    throw new RuntimeException("Simulated error!");
                }
                Thread.sleep(1000L);
                return Thread.currentThread().getName() + ": task completed successfully";
            };

            Future<String> future = executor.submit(task);
            String result = null;
            try {
                result = future.get();
                System.out.println("Result: " + result);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task interrupted.");
            } catch (ExecutionException e) {
                System.out.println("Task failed with exception " +
                        e.getCause().getMessage());
                break;
            } finally {
                executor.shutdown();
            }
        }
    }
}
