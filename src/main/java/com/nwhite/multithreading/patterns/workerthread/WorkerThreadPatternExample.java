package com.nwhite.multithreading.patterns.workerthread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkerThreadPatternExample {

    public static void main(String[] args) {
        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
        int numberOfWorkers = 3; // pool size
        Worker[] workers = new Worker[numberOfWorkers];

        // start workers
        for (int i = 0; i < numberOfWorkers; i++) {
            workers[i] = new Worker(taskQueue);
            workers[i].start();
        }

        // add tasks to the queue
        for (int i = 1; i <= 10; i++) {
            taskQueue.add(new Task(i));
        }

        // stop workers after all tasks are processed
        try {
            Thread.sleep(12000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // interrupt workers to stop them
        for (Worker worker : workers) {
            worker.interrupt();
        }
    }
}
