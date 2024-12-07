package org.revian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {
    private MyArray array;

    @BeforeEach
    void setUp() {
        array = new MyArray(5);
    }

    @Test
    void testAddAndGet() {
        array.add(1);
        assertEquals(1, array.get(0));
    }

    @Test
    void testSize() {
        array.add(1);
        array.add(2);
        assertEquals(2, array.size());
    }

    @Test
    void testAddWhenFull() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(6));
    }

    @Test
    void testGetInvalidIndex() {
        array.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(2));
    }
}

