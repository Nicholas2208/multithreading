package com.nwhite.multithreading.timertask;

import java.util.Timer;
import java.util.TimerTask;

public class SingleShotTimer {

    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tick");
            }
        };

        timer.schedule(task, 1000L);

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        timer.cancel();

        System.out.println("Main: done.");
    }
}
