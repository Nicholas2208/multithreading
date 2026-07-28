package com.nwhite.multithreading.producerconsumer;

public class ProducerConsumerExample1 {

    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer();

        // producer thread
        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                sharedBuffer.produce(i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Producer Thread");

        // consumer thread
        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                sharedBuffer.consume();
            }
            try {
                Thread.sleep(800L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer Thread");

        producerThread.start();
        consumerThread.start();
    }
}
