package com.nwhite.multithreading.producerconsumer.orders;

import java.util.Random;

public class Producer implements Runnable {
    private final SharedBuffer sharedBuffer;
    private int orderId = 0;

    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        String[] products = {"Keyboard", "Laptop", "Phone", "Headphone", "Monitor"};
        Random random = new Random();
        while (true) {
            try {
                // generate a random order
                String productName = products[random.nextInt(products.length)];
                int quantity = random.nextInt(1, 6);
                Order order = new Order(++orderId, productName, quantity);
                sharedBuffer.produce(order);
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
