package com.nwhite.multithreading.interaction;

public class JoinExample {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread t1 started");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long elapsed = (System.currentTimeMillis() - start) / 1000;
                System.out.format("Thread t1 terminated in %d seconds", elapsed);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread t2 is running and will wait for t1 to terminate or 3 seconds to elapse.");
                    t1.join(3000);
                    System.out.println("Thread t2 is running again after t1 finished or timed out.");
                    long elapsed = (System.currentTimeMillis() - start) / 1000;
                    System.out.format("Thread t2 terminated in %d seconds ...", elapsed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
