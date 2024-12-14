package org.revian.BigO;

import org.junit.jupiter.api.Test;
import org.revian.MyHeap;

import java.util.Random;

class MyHeapBigOTest {

    @Test
    void testInsertBigO() {
        MyHeap heap = new MyHeap();

        int[] sizes = {100, 1000, 10000, 50000}; // Different input sizes
        Random random = new Random();
        for (int size : sizes) {
            long startTime = System.nanoTime();

            // Insert random elements
            for (int i = 0; i < size; i++) {
                heap.insert(random.nextInt(100000)); // Random number between 0 and 99999
            }

            long endTime = System.nanoTime();
            System.out.printf("Insert Time for %d elements: %d ns%n", size, endTime - startTime);
        }
    }

    @Test
    void testExtractMinBigO() {
        MyHeap heap = new MyHeap();
        Random random = new Random();

        int[] sizes = {100, 1000, 10000}; // Different input sizes
        for (int size : sizes) {
            // Insert elements into heap
            for (int i = 0; i < size; i++) {
                heap.insert(random.nextInt(100000));
            }

            long startTime = System.nanoTime();

            // Extract min element repeatedly
            for (int i = 0; i < size; i++) {
                heap.extractMin(); // Assume it's a min-heap
            }

            long endTime = System.nanoTime();
            System.out.printf("ExtractMin Time for %d elements: %d ns%n", size, endTime - startTime);
        }
    }

    @Test
    void testHeapifyBigO() {
        MyHeap heap = new MyHeap();
        Random random = new Random();

        int[] sizes = {100, 1000, 10000}; // Different input sizes
        for (int size : sizes) {
            // Create an unsorted array of elements
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(100000); // Random number between 0 and 99999
            }

            long startTime = System.nanoTime();

            // Perform heapify operation
            heap.heapify(arr); // Assume heapify converts the array into a heap

            long endTime = System.nanoTime();
            System.out.printf("Heapify Time for %d elements: %d ns%n", size, endTime - startTime);
        }
    }

    @Test
    void testPeekBigO() {
        MyHeap heap = new MyHeap();
        Random random = new Random();

        int[] sizes = {100, 1000, 10000}; // Different input sizes
        for (int size : sizes) {
            // Insert elements into heap
            for (int i = 0; i < size; i++) {
                heap.insert(random.nextInt(100000));
            }

            long startTime = System.nanoTime();

            // Peek operation (O(1) time complexity)
            heap.peek();

            long endTime = System.nanoTime();
            System.out.printf("Peek Time for %d elements: %d ns%n", size, endTime - startTime);
        }
    }
}
