package com.nwhite.multithreading.timertask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Equivalent to TimerTask
 */
public class SingleShotScheduled {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.schedule(() -> System.out.println("Tick"), 1, TimeUnit.SECONDS);

        Thread.sleep(2000L);
        scheduler.shutdown();
        System.out.println("Main: done.");
    }
}
