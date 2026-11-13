package com.nwhite.multithreading.yield;

public class YieldDemo implements Runnable {
    private final String name;

    public YieldDemo(String name) {
        this.name = name;
    }

    /**
     * Comment out the Thread.yield() call and see the difference in the output.
     */
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": step " + i);
            Thread.yield();
        }
        System.out.println(name + ": done");
    }
}
