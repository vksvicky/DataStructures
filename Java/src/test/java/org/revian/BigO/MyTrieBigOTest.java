package org.revian.BigO;

import org.junit.jupiter.api.Test;
import org.revian.MyTrie;

import java.util.Random;

class MyTrieBigOTest {

    @Test
    void testInsertBigO() {
        MyTrie trie = new MyTrie();

        int[] sizes = {100, 1000, 10000, 50000}; // Different word lengths
        Random random = new Random();
        for (int size : sizes) {
            String word = generateRandomWord(size);
            long startTime = System.nanoTime();

            trie.insert(word);

            long endTime = System.nanoTime();
            System.out.printf("Insert Time for word of length %d: %d ns%n", size, endTime - startTime);
        }
    }

    @Test
    void testSearchBigO() {
        MyTrie trie = new MyTrie();

        int numWords = 10000;
        Random random = new Random();
        // Insert 10000 words
        for (int i = 0; i < numWords; i++) {
            trie.insert(generateRandomWord(10));
        }

        int[] lookups = {100, 1000, 10000}; // Different search lengths
        for (int lookupCount : lookups) {
            String word = generateRandomWord(lookupCount);
            long startTime = System.nanoTime();

            trie.search(word);

            long endTime = System.nanoTime();
            System.out.printf("Search Time for word of length %d: %d ns%n", lookupCount, endTime - startTime);
        }
    }

    @Test
    void testStartsWithBigO() {
        MyTrie trie = new MyTrie();

        int numWords = 10000;
        Random random = new Random();
        // Insert 10000 words
        for (int i = 0; i < numWords; i++) {
            trie.insert(generateRandomWord(10));
        }

        int[] prefixes = {5, 10, 15}; // Different prefix lengths
        for (int prefixLength : prefixes) {
            String prefix = generateRandomWord(prefixLength);
            long startTime = System.nanoTime();

            trie.startsWith(prefix);

            long endTime = System.nanoTime();
            System.out.printf("StartsWith Time for prefix of length %d: %d ns%n", prefixLength, endTime - startTime);
        }
    }

    @Test
    void testDeleteBigO() {
        MyTrie trie = new MyTrie();

        int numWords = 10000;
        Random random = new Random();
        // Insert 10000 words
        for (int i = 0; i < numWords; i++) {
            trie.insert(generateRandomWord(10));
        }

        int[] deleteSizes = {100, 1000, 10000}; // Different delete word lengths
        for (int deleteSize : deleteSizes) {
            String word = generateRandomWord(deleteSize);
            long startTime = System.nanoTime();

            trie.delete(word);

            long endTime = System.nanoTime();
            System.out.printf("Delete Time for word of length %d: %d ns%n", deleteSize, endTime - startTime);
        }
    }

    // Helper method to generate random words of specified length
    private String generateRandomWord(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + (Math.random() * 26)));  // Generate a random lowercase letter
        }
        return sb.toString();
    }
}
