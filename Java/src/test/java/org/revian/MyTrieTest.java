package org.revian;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyTrieTest {

    @Test
    void testInsertAndSearchHappyPath() {
        MyTrie trie = new MyTrie();
        trie.insert("apple");
        trie.insert("app");
        assertTrue(trie.search("apple"));
        assertTrue(trie.search("app"));
    }

    @Test
    void testSearchNonExistentWord() {
        MyTrie trie = new MyTrie();
        trie.insert("apple");
        assertFalse(trie.search("banana"));
    }

    @Test
    void testStartsWithHappyPath() {
        MyTrie trie = new MyTrie();
        trie.insert("apple");
        assertTrue(trie.startsWith("app"));
    }

    @Test
    void testStartsWithNonExistentPrefix() {
        MyTrie trie = new MyTrie();
        trie.insert("apple");
        assertFalse(trie.startsWith("ban"));
    }

    @Test
    void testInsertNullWord() {
        MyTrie trie = new MyTrie();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> trie.insert(null));
        assertEquals("Invalid word: Cannot insert null or empty word", exception.getMessage());
    }

    @Test
    void testSearchNullWord() {
        MyTrie trie = new MyTrie();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> trie.search(null));
        assertEquals("Invalid word: Cannot search null or empty word", exception.getMessage());
    }

    @Test
    void testStartsWithNullPrefix() {
        MyTrie trie = new MyTrie();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> trie.startsWith(null));
        assertEquals("Invalid prefix: Cannot check null or empty prefix", exception.getMessage());
    }

    @Test
    void testInsertEmptyWord() {
        MyTrie trie = new MyTrie();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> trie.insert(""));
        assertEquals("Invalid word: Cannot insert null or empty word", exception.getMessage());
    }

    @Test
    void testSearchEmptyWord() {
        MyTrie trie = new MyTrie();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> trie.search(""));
        assertEquals("Invalid word: Cannot search null or empty word", exception.getMessage());
    }

    @Test
    void testStartsWithEmptyPrefix() {
        MyTrie trie = new MyTrie();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> trie.startsWith(""));
        assertEquals("Invalid prefix: Cannot check null or empty prefix", exception.getMessage());
    }
}