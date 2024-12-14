package org.revian.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.revian.MyHeap;

import static org.junit.jupiter.api.Assertions.*;

public class MyHeapStepDefinitions {

    private MyHeap heap;

    @Given("the heap is empty")
    public void theHeapIsEmpty() {
        heap = new MyHeap();
    }

    @Given("the heap contains {int}, {int}, and {int}")
    public void theHeapContainsElements(int a, int b, int c) {
        heap = new MyHeap();
        heap.insert(a);
        heap.insert(b);
        heap.insert(c);
    }

    @When("I insert {int} into the heap")
    public void iInsertIntoTheHeap(int element) {
        heap.insert(element);
    }

    @When("I extract the minimum element")
    public void iExtractTheMinimumElement() {
        heap.extractMin();
    }

    @When("I try to extract the minimum element")
    public void iTryToExtractTheMinimumElement() {
        try {
            heap.extractMin();
        } catch (IllegalStateException e) {
            // Error handling is done in the Then step
        }
    }

    @When("I peek into the heap")
    public void iPeekIntoTheHeap() {
        heap.peek();
    }

    @When("I heapify the array {int}, {int}, {int}, {int}, {int}")
    public void iHeapifyTheArray(int a, int b, int c, int d, int e) {
        heap.heapify(new int[]{a, b, c, d, e});
    }

    @Then("the minimum element should be {int}")
    public void theMinimumElementShouldBe(int expectedMin) {
        assertEquals(expectedMin, heap.peek());
    }

    @Then("the extracted element should be {int}")
    public void theExtractedElementShouldBe(int expectedElement) {
        assertEquals(expectedElement, heap.extractMin());
    }

    @Then("the new minimum element should be {int}")
    public void theNewMinimumElementShouldBe(int expectedMin) {
        assertEquals(expectedMin, heap.peek());
    }

    @Then("I should receive an error {string}")
    public void iShouldReceiveAnError(String errorMessage) {
        assertThrows(IllegalStateException.class, heap::extractMin);
    }
}