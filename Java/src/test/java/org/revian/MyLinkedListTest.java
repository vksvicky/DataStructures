package org.revian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    private MyLinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new MyLinkedList();
    }

    @Test
    void testAddAndGet() {
        linkedList.add(1);
        linkedList.add(2);
        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
    }

    @Test
    void testSize() {
        linkedList.add(1);
        linkedList.add(2);
        assertEquals(2, linkedList.size());
    }

    @Test
    void testGetInvalidIndex() {
        linkedList.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2));
    }
}

