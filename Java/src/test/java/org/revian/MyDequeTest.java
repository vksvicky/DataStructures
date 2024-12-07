package org.revian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDequeTest {
    private MyDeque deque;

    @BeforeEach
    void setUp() {
        deque = new MyDeque();
    }

    @Test
    void testAddFirstAndRemoveFirst() {
        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.removeFirst());
    }

    @Test
    void testAddLastAndRemoveLast() {
        deque.addLast(1);
        deque.addLast(2);
        assertEquals(2, deque.removeLast());
        assertEquals(1, deque.removeLast());
    }

    @Test
    void testSize() {
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(2, deque.size());
    }

    @Test
    void testRemoveFirstEmptyDeque() {
        assertThrows(IllegalStateException.class, () -> deque.removeFirst());
    }

    @Test
    void testRemoveLastEmptyDeque() {
        assertThrows(IllegalStateException.class, () -> deque.removeLast());
    }
}

