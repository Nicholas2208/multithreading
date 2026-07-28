package com.nwhite.multithreading.futurecallable;

import java.util.concurrent.*;

public class FutureCallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> callableTask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is executing Callable task");
            Thread.sleep(2000L);
            return "Result from " + threadName;
        };

        Future<String> futureResult = executor.submit(callableTask);
        String result = futureResult.get();

        System.out.println("Result: " + result);
        executor.shutdown();
    }
}
