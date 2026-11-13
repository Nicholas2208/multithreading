package com.nwhite.multithreading.callable;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ReverseCallable implements Callable<String> {
    private final String input;

    public ReverseCallable(String input) {
        this.input = input;
    }

    @Override
    public String call() throws Exception {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a line: ");
        String line = scanner.nextLine();
        scanner.close();

        Callable<String> task = new ReverseCallable(line);
        FutureTask<String> future = new FutureTask<>(task);
        Thread thread = new Thread(future);
        thread.start();

        try {
            String reversed = future.get();   // blocks until the result is ready
            System.out.println(reversed);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread was interrupted while waiting.");
        } catch (ExecutionException e) {
            System.err.println("Task failed: " + e.getCause());
        }

        System.out.println("Main: thread has finished.");
    }
}
