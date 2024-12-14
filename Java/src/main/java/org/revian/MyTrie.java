package org.revian;

import java.util.HashMap;
import java.util.Map;

//Interpreting the Results
//	•	The execution time should increase linearly with the length of the words or prefixes for each operation, confirming that the operations are O(L).
//  •	The times should not grow disproportionately to the length of the words, validating that the implementation follows the expected time complexity.
public class MyTrie {

    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public MyTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid word: Cannot insert null or empty word");
        }
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid word: Cannot search null or empty word");
        }
        TrieNode node = getNode(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            throw new IllegalArgumentException("Invalid prefix: Cannot check null or empty prefix");
        }
        return getNode(prefix) != null;
    }

    private TrieNode getNode(String str) {
        TrieNode current = root;
        for (char ch : str.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    // Delete a word from the Trie
    public boolean delete(String word) {
        return deleteHelper(root, word, 0);
    }

    // Helper method for delete
    private boolean deleteHelper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            // If we've reached the end of the word, unmark isEndOfWord
            if (!node.isEndOfWord) {
                return false; // Word doesn't exist
            }
            node.isEndOfWord = false;

            // If the node has no children, we can safely delete this node
            return node.children.isEmpty();
        }

        char c = word.charAt(index);
        TrieNode nextNode = node.children.get(c);

        if (nextNode == null) {
            return false; // Word doesn't exist
        }

        // Recursively delete the character
        boolean shouldDeleteCurrentNode = deleteHelper(nextNode, word, index + 1);

        // If true is returned, we can delete the current node
        if (shouldDeleteCurrentNode) {
            node.children.remove(c);
            // Return true if current node has no children and is not an end of another word
            return node.children.isEmpty() && !node.isEndOfWord;
        }

        return false;
    }
}
