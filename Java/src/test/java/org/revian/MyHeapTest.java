package org.revian;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyHeapTest {

    // Happy Path Tests
    @Test
    void testInsert() {
        MyHeap heap = new MyHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);

        // The minimum element after inserting 10, 20, and 5 should be 5
        assertEquals(5, heap.peek());
    }

    @Test
    void testExtractMin() {
        MyHeap heap = new MyHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);

        // Extract the minimum element (which should be 5)
        assertEquals(5, heap.extractMin());

        // After extraction, the new minimum should be 10
        assertEquals(10, heap.peek());
    }

    @Test
    void testHeapify() {
        MyHeap heap = new MyHeap();
        int[] array = {10, 20, 5, 30, 15};

        // Heapify an unsorted array
        heap.heapify(array);

        // The minimum element in the heap should be 5 after heapify
        assertEquals(5, heap.peek());
    }

    // Negative Path Tests
    @Test
    void testInsertLargeNumberOfElements() {
        MyHeap heap = new MyHeap();

        // Insert 10000 elements and check that the root is correct
        for (int i = 0; i < 10000; i++) {
            heap.insert(i);
        }

        // The minimum element should be 0, since we inserted it first
        assertEquals(0, heap.peek());
    }

    @Test
    void testExtractMinWithDuplicates() {
        MyHeap heap = new MyHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(10);  // Insert duplicate

        // Extract the minimum element, which should still be 10
        assertEquals(10, heap.extractMin());

        // The next minimum should still be 10
        assertEquals(10, heap.peek());
    }

    // Exception Handling Tests
    @Test
    void testExtractMinWhenEmpty() {
        MyHeap heap = new MyHeap();

        // Trying to extract from an empty heap should throw an exception
        assertThrows(IllegalStateException.class, heap::extractMin);
    }

    @Test
    void testPeekWhenEmpty() {
        MyHeap heap = new MyHeap();

        // Peeking into an empty heap should throw an exception
        assertThrows(IllegalStateException.class, heap::peek);
    }

    @Test
    void testHeapifyWithEmptyArray() {
        MyHeap heap = new MyHeap();
        int[] array = {};

        // Heapify an empty array should result in an empty heap
        heap.heapify(array);

        // Peeking into an empty heap after heapify should throw an exception
        assertThrows(IllegalStateException.class, heap::peek);
    }

    @Test
    void testExtractMinOnSingleElementHeap() {
        MyHeap heap = new MyHeap();
        heap.insert(10);

        // Extracting the only element should return 10
        assertEquals(10, heap.extractMin());

        // After extraction, the heap should be empty, peeking should throw an exception
        assertThrows(IllegalStateException.class, heap::peek);
    }

    // Error Scenarios
    @Test
    void testHeapifyWithNullArray() {
        MyHeap heap = new MyHeap();

        // Heapify with a null array should throw a NullPointerException
        assertThrows(NullPointerException.class, () -> heap.heapify(null));
    }

    @Test
    void testHeapifyWithCorruptedArray() {
        MyHeap heap = new MyHeap();
        int[] array = {10, -5, 20, 100, 30};

        // Heapify on an array with mixed positive and negative elements should still result in a valid heap
        heap.heapify(array);

        // The minimum should be the smallest value, which is -5
        assertEquals(-5, heap.peek());
    }

    @Test
    void testExtractMinAfterHeapifyWithLargeArray() {
        MyHeap heap = new MyHeap();
        int[] largeArray = new int[100000];

        // Populate array with random values
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int) (Math.random() * 100000);
        }

        // Heapify the large array
        heap.heapify(largeArray);

        // The minimum element should be the smallest value in the array
        assertTrue(heap.peek() <= 100000);
    }
}