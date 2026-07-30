package com.nwhite.multithreading.forkjoin;

import com.nwhite.multithreading.forkjoin.example1.SumTask;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ForkJoinPool;
import static org.junit.jupiter.api.Assertions.*;

public class SumTaskTest {

    @Test
    void testSumOfSingleElement() {
        int[] array = {42};
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        Integer result = pool.invoke(task);
        assertEquals(42, result);
    }

    @Test
    void testSumOfTwoElements() {
        int[] array = {10, 20};
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        Integer result = pool.invoke(task);
        assertEquals(30, result);
    }

    @Test
    void testSumOfMultipleElements() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        Integer result = pool.invoke(task);
        assertEquals(55, result);
    }

    @Test
    void testSumWithMixedNumbers() {
        int[] array = {-10, 20, -30, 40, -50};
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        Integer result = pool.invoke(task);
        assertEquals(-30, result);
    }

    @Test
    void testSumOfLargeArray() {
        int size = 1000000;
        int[] array = new int[size];
        int expectedSum = 0;
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            expectedSum += i + 1;
        }

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        Integer result = pool.invoke(task);
        assertEquals(expectedSum, result);
    }

    @Test
    void testSumWithAllZeros() {
        int[] array = {0, 0, 0, 0, 0, 0, 0, 0};
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        Integer result = pool.invoke(task);
        assertEquals(0, result);
    }

    @Test
    void testLargeNumbers() {
        int[] array = {Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2};
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        Integer result = pool.invoke(task);
        assertEquals(Integer.MAX_VALUE - 1, result);
    }
}
