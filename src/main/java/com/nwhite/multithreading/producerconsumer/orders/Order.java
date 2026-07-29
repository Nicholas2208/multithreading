package com.nwhite.multithreading.producerconsumer.orders;

public record Order(int orderId, String productName, int quantity) { }
