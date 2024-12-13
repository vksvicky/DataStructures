package org.revian.stepDefinitions;

import io.cucumber.java.en.*;
import org.revian.MyHashMap;

import static org.junit.jupiter.api.Assertions.*;

public class MyHashMapStepDefinitions {

    MyHashMap<String, String> map;

    @Given("an empty MyHashMap")
    public void an_empty_myhashmap() {
        map = new MyHashMap<>();
    }

    @Given("a MyHashMap with key {string} and value {string}")
    public void a_myhashmap_with_key_and_value(String key, String value) {
        map = new MyHashMap<>();
        map.put(key, value);
    }

    @When("I add a key {string} with value {string}")
    public void i_add_a_key_with_value(String key, String value) {
        map.put(key, value);
    }

    @When("I update the key {string} with value {string}")
    public void i_update_the_key_with_value(String key, String value) {
        map.put(key, value);
    }

    @When("I remove the key {string}")
    public void i_remove_the_key(String key) {
        map.remove(key);
    }

    @When("I add a null key")
    public void i_add_a_null_key() {
        try {
            map.put(null, "Value1");
        } catch (IllegalArgumentException e) {
            assertEquals("Key cannot be null", e.getMessage());
        }
    }

    @Then("the map should return {string} for {string}")
    public void the_map_should_return_for(String value, String key) {
        assertEquals(value, map.get(key));
    }

    @Then("the map should not contain {string}")
    public void the_map_should_not_contain(String key) {
        assertFalse(map.containsKey(key));
    }

    @Then("an exception should be thrown with message {string}")
    public void an_exception_should_be_thrown_with_message(String message) {
        assertThrows(IllegalArgumentException.class, () -> map.put(null, "Value1"));
    }
}

