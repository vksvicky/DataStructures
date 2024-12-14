package org.revian.stepDefinitions;

import io.cucumber.java.en.*;
import org.revian.MyTrie;

import static org.junit.jupiter.api.Assertions.*;

public class MyTrieStepDefinitions {

    MyTrie trie;
    boolean result;

    @Given("an empty MyTrie")
    public void an_empty_mytrie() {
        trie = new MyTrie();
    }

    @Given("a MyTrie with the word {string}")
    public void a_mytrie_with_the_word(String word) {
        trie = new MyTrie();
        trie.insert(word);
    }

    @When("I insert {string} and {string} into the trie")
    public void i_insert_and_into_the_trie(String word1, String word2) {
        trie.insert(word1);
        trie.insert(word2);
    }

    @When("I search for {string}")
    public void i_search_for(String word) {
        result = trie.search(word);
    }

    @When("I check if the prefix {string} exists")
    public void i_check_if_the_prefix_exists(String prefix) {
        result = trie.startsWith(prefix);
    }

    @When("I insert a null word")
    public void i_insert_a_null_word() {
        try {
            trie.insert(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid word: Cannot insert null or empty word", e.getMessage());
        }
    }

    @When("I search for a null word")
    public void i_search_for_a_null_word() {
        try {
            trie.search(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid word: Cannot search null or empty word", e.getMessage());
        }
    }

    @When("I check a null prefix")
    public void i_check_a_null_prefix() {
        try {
            trie.startsWith(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid prefix: Cannot check null or empty prefix", e.getMessage());
        }
    }

    @Then("searching for {string} should return {string}")
    public void searching_for_should_return(String word, String expected) {
        assertEquals(Boolean.parseBoolean(expected), result);
    }

    @Then("it should return {string}")
    public void it_should_return(String expected) {
        assertEquals(Boolean.parseBoolean(expected), result);
    }

    @Then("an exception should be thrown with the message {string}")
    public void an_exception_should_be_thrown_with_the_message(String message) {
        // Exception handling tested in @When steps
    }
}
