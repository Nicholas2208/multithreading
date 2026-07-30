package com.nwhite.multithreading.forkjoin.example3;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        int[] array = {13, 51, -5, 0, 12, 743, 16, -9, 33, 96};
        FindMaxTask task = new FindMaxTask(array, 0, array.length);
        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(task);
        System.out.println("The max is: " + result);
    }
}
