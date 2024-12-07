package org.revian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    private MyQueue queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue();
    }

    @Test
    void testEnqueueAndDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
    }

    @Test
    void testSize() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
    }

    @Test
    void testDequeueEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }
}
