package org.revian;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyPriorityQueueTest {

    @Test
    void testAddAndPeekHappyPath() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.add(10);
        queue.add(5);
        queue.add(20);
        assertEquals(5, queue.peek());
    }

    @Test
    void testPollHappyPath() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.add(10);
        queue.add(5);
        queue.add(20);
        assertEquals(5, queue.poll());
        assertEquals(10, queue.poll());
    }

    @Test
    void testPollFromEmptyQueue() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        Exception exception = assertThrows(IllegalStateException.class, queue::poll);
        assertEquals("PriorityQueue is empty", exception.getMessage());
    }

    @Test
    void testPeekFromEmptyQueue() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        Exception exception = assertThrows(IllegalStateException.class, queue::peek);
        assertEquals("PriorityQueue is empty", exception.getMessage());
    }

    @Test
    void testAddNullElement() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> queue.add(null));
        assertEquals("Element cannot be null", exception.getMessage());
    }

    @Test
    void testIsEmpty() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        assertTrue(queue.isEmpty());
        queue.add(10);
        assertFalse(queue.isEmpty());
    }

    @Test
    void testSize() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.add(10);
        queue.add(5);
        queue.add(20);
        assertEquals(3, queue.size());
        queue.poll();
        assertEquals(2, queue.size());
    }
}

