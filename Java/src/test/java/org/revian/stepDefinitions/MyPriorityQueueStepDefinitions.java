package org.revian.stepDefinitions;

import io.cucumber.java.en.*;
import org.revian.MyPriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class MyPriorityQueueStepDefinitions {

    MyPriorityQueue<Integer> queue;

    @Given("an empty MyPriorityQueue")
    public void an_empty_mypriorityqueue() {
        queue = new MyPriorityQueue<>();
    }

    @Given("a MyPriorityQueue with elements {int}, {int}, and {int}")
    public void a_mypriorityqueue_with_elements(int elem1, int elem2, int elem3) {
        queue = new MyPriorityQueue<>();
        queue.add(elem1);
        queue.add(elem2);
        queue.add(elem3);
    }

    @When("I add {int}, {int}, and {int} to the queue")
    public void i_add_to_the_queue(int elem1, int elem2, int elem3) {
        queue.add(elem1);
        queue.add(elem2);
        queue.add(elem3);
    }

    @When("I poll an element")
    public void i_poll_an_element() {
        queue.poll();
    }

    @When("I peek the top element")
    public void i_peek_the_top_element() {
        try {
            queue.peek();
        } catch (IllegalStateException e) {
            assertEquals("PriorityQueue is empty", e.getMessage());
        }
    }

    @When("I add a null element")
    public void i_add_a_null_element() {
        try {
            queue.add(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Element cannot be null", e.getMessage());
        }
    }

    @Then("the top element should be {int}")
    public void the_top_element_should_be(int expected) {
        assertEquals(expected, queue.peek());
    }

    @Then("the returned element should be {int}")
    public void the_returned_element_should_be(int expected) {
        assertEquals(expected, queue.poll());
    }

    @Then("an exception should be thrown with message {string}")
    public void an_exception_should_be_thrown_with_message(String message) {
        Exception exception = assertThrows(IllegalStateException.class, queue::peek);
        assertEquals(message, exception.getMessage());
    }
}

