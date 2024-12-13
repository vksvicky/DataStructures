package org.revian;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MySetTest {

    @Test
    void testAddAndContainsHappyPath() {
        MySet<String> set = new MySet<>();
        set.add("Element1");
        assertTrue(set.contains("Element1"));
    }

    @Test
    void testAddDuplicate() {
        MySet<String> set = new MySet<>();
        set.add("Element1");
        set.add("Element1");
        assertEquals(1, set.size());
    }

    @Test
    void testRemoveElement() {
        MySet<String> set = new MySet<>();
        set.add("Element1");
        set.remove("Element1");
        assertFalse(set.contains("Element1"));
    }

    @Test
    void testContainsNonExistentElement() {
        MySet<String> set = new MySet<>();
        assertFalse(set.contains("NonExistent"));
    }

    @Test
    void testSize() {
        MySet<String> set = new MySet<>();
        set.add("Element1");
        set.add("Element2");
        assertEquals(2, set.size());
        set.remove("Element1");
        assertEquals(1, set.size());
    }

    @Test
    void testIsEmpty() {
        MySet<String> set = new MySet<>();
        assertTrue(set.isEmpty());
        set.add("Element1");
        assertFalse(set.isEmpty());
    }

    @Test
    void testAddNullThrowsException() {
        MySet<String> set = new MySet<>();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> set.add(null));
        assertEquals("Element cannot be null", exception.getMessage());
    }

    @Test
    void testRemoveNullThrowsException() {
        MySet<String> set = new MySet<>();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> set.remove(null));
        assertEquals("Element cannot be null", exception.getMessage());
    }
}

