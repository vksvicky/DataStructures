package org.revian.stepDefinitions;

import io.cucumber.java.en.*;
import org.revian.MyHeap;

import static org.junit.jupiter.api.Assertions.*;

public class MyHeapStepDefinitions {

    MyHeap<Integer> heap;

    @Given("an empty MyHeap")
    public void an_empty_myheap() {
        heap = new MyHeap<>();
    }

    @Given("a MyHeap with elements {int}, {int}, and {int}")
    public void a_myheap_with_elements(int elem1, int elem2, int elem3) {
        heap = new MyHeap<>();
        heap.insert(elem1);
        heap.insert(elem2);
        heap.insert(elem3);
    }

    @When("I insert {int}, {int}, and {int} into the heap")
    public void i_insert_into_the_heap(int elem1, int elem2, int elem3) {
        heap.insert(elem1);
        heap.insert(elem2);
        heap.insert(elem3);
    }

    @When("I remove the minimum element")
    public void i_remove_the_minimum_element() {
        heap.removeMin();
    }

    @When("I get the minimum element")
    public void i_get_the_minimum_element() {
        try {
            heap.getMin();
        } catch (IllegalStateException e) {
            assertEquals("Heap is empty", e.getMessage());
        }
    }

    @When("I insert a null element")
    public void i_insert_a_null_element() {
        try {
            heap.insert(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Element cannot be null", e.getMessage());
        }
    }

    @Then("the minimum element should be {int}")
    public void the_minimum_element_should_be(int expected) {
        assertEquals(expected, heap.getMin());
    }

    @Then("the returned element should be {int}")
    public void the_returned_element_should_be(int expected) {
        assertEquals(expected, heap.removeMin());
    }

    @Then("an exception should be thrown with message {string}")
    public void an_exception_should_be_thrown_with_message(String message) {
        Exception exception = assertThrows(IllegalStateException.class, heap::getMin);
        assertEquals(message, exception.getMessage());
    }
}

