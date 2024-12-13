package org.revian;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyHeapTest {

    @Test
    void testInsertAndGetMinHappyPath() {
        MyHeap<Integer> heap = new MyHeap<>();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        assertEquals(5, heap.getMin());
    }

    @Test
    void testRemoveMinHappyPath() {
        MyHeap<Integer> heap = new MyHeap<>();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        assertEquals(5, heap.removeMin());
        assertEquals(10, heap.getMin());
    }

    @Test
    void testRemoveMinFromEmptyHeap() {
        MyHeap<Integer> heap = new MyHeap<>();
        Exception exception = assertThrows(IllegalStateException.class, heap::removeMin);
        assertEquals("Heap is empty", exception.getMessage());
    }

    @Test
    void testGetMinFromEmptyHeap() {
        MyHeap<Integer> heap = new MyHeap<>();
        Exception exception = assertThrows(IllegalStateException.class, heap::getMin);
        assertEquals("Heap is empty", exception.getMessage());
    }

    @Test
    void testInsertNullElement() {
        MyHeap<Integer> heap = new MyHeap<>();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> heap.insert(null));
        assertEquals("Element cannot be null", exception.getMessage());
    }

    @Test
    void testIsEmpty() {
        MyHeap<Integer> heap = new MyHeap<>();
        assertTrue(heap.isEmpty());
        heap.insert(10);
        assertFalse(heap.isEmpty());
    }

    @Test
    void testSize() {
        MyHeap<Integer> heap = new MyHeap<>();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        assertEquals(3, heap.size());
        heap.removeMin();
        assertEquals(2, heap.size());
    }
}

