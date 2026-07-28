package com.nwhite.multithreading.producerconsumer;

public class ProducerConsumerExample2 {

    public static void main(String[] args) {
        SharedBufferWithLock sharedBuffer = new SharedBufferWithLock();

        // Producer Thread
        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                sharedBuffer.produce(i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Producer Thread");

        // Consumer Thread
        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                sharedBuffer.consume();
                try {
                    Thread.sleep(800L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
