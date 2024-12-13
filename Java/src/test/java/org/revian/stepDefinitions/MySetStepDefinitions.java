package org.revian.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.revian.MySet;

import static org.junit.jupiter.api.Assertions.*;

public class MySetStepDefinitions {

    MySet<String> set;

    @Given("an empty MySet")
    public void an_empty_myset() {
        set = new MySet<>();
    }

    @Given("a MySet with {string}")
    public void a_myset_with(String element) {
        set = new MySet<>();
        set.add(element);
    }

    @When("I add {string} to the set")
    public void i_add_to_the_set(String element) {
        set.add(element);
    }

    @When("I remove {string}")
    public void i_remove(String element) {
        set.remove(element);
    }

    @When("I add a null element")
    public void i_add_a_null_element() {
        try {
            set.add(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Element cannot be null", e.getMessage());
        }
    }

    @Then("the set should contain {string}")
    public void the_set_should_contain(String element) {
        assertTrue(set.contains(element));
    }

    @Then("the set should not contain {string}")
    public void the_set_should_not_contain(String element) {
        assertFalse(set.contains(element));
    }

    @Then("the size of the set should be {int}")
    public void the_size_of_the_set_should_be(int size) {
        assertEquals(size, set.size());
    }

    @Then("the set should be empty")
    public void the_set_should_be_empty() {
        assertTrue(set.isEmpty());
    }

    @Then("an exception should be thrown with message {string}")
    public void an_exception_should_be_thrown_with_message(String message) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> set.add(null));
        assertEquals(message, exception.getMessage());
    }
}

