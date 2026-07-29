package com.nwhite.multithreading.lock;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample readWriteLockExample = new ReadWriteLockExample();

        Thread writerThread = new Thread(
                () -> readWriteLockExample.writeData(49),
                "Writer Thread");

        Thread reader1 = new Thread(readWriteLockExample::readData, "Reader 1");
        Thread reader2 = new Thread(readWriteLockExample::readData, "Reader 2");

        writerThread.start();
        reader1.start();
        reader2.start();

        writerThread.join();
        reader1.join();
        reader2.join();
    }
}
