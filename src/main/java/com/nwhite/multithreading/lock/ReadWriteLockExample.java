package com.nwhite.multithreading.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private int data;

    public void writeData(int value) {
        writeLock.lock();
        try {
            data = value;
            System.out.println(Thread.currentThread().getName() + " write: " + data);
        } finally {
            writeLock.unlock();
        }
    }

    public void readData() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " read: " + data);
        } finally {
            readLock.unlock();
        }
    }
}
