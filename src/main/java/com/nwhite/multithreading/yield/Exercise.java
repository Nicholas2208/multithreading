package com.nwhite.multithreading.yield;

public class Exercise {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new YieldDemo("Thread-A"));
        Thread t2 = new Thread(new YieldDemo("Thread-B"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Main: both threads finished.");
    }
}
