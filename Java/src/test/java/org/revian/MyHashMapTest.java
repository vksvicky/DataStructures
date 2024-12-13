package org.revian;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void testPutAndGetHappyPath() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Key1", "Value1");
        assertEquals("Value1", map.get("Key1"));
    }

    @Test
    void testGetNonExistentKey() {
        MyHashMap<String, String> map = new MyHashMap<>();
        assertNull(map.get("NonExistentKey"));
    }

    @Test
    void testPutAndOverrideValue() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Key1", "Value1");
        map.put("Key1", "NewValue");
        assertEquals("NewValue", map.get("Key1"));
    }

    @Test
    void testRemoveKey() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Key1", "Value1");
        map.remove("Key1");
        assertNull(map.get("Key1"));
    }

    @Test
    void testContainsKey() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Key1", "Value1");
        assertTrue(map.containsKey("Key1"));
        assertFalse(map.containsKey("Key2"));
    }

    @Test
    void testSize() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Key1", "Value1");
        map.put("Key2", "Value2");
        assertEquals(2, map.size());
        map.remove("Key1");
        assertEquals(1, map.size());
    }

    @Test
    void testNullKeyException() {
        MyHashMap<String, String> map = new MyHashMap<>();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> map.put(null, "Value1"));
        assertEquals("Key cannot be null", exception.getMessage());
    }
}

