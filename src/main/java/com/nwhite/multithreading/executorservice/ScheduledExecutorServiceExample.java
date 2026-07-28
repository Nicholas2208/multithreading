package com.nwhite.multithreading.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
//        for (int i = 0; i < 5; i++) {
//            Task task = new Task("Task " + i);
//            executor.schedule(task, i*2, TimeUnit.SECONDS);
//        }

//        executor.scheduleAtFixedRate(
//                new Task("Fixed Rate Task"),
//                1,
//                5,
//                TimeUnit.SECONDS
//        );

        executor.scheduleWithFixedDelay(
                new Task("Fixed Delay Task"),
                2,
                5,
                TimeUnit.SECONDS
        );

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.println("ScheduledExecutorService shutdown");
    }
}
