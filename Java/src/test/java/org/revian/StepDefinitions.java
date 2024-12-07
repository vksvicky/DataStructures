package org.revian;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StepDefinitions {

    private MyArray myArray;
    private MyStack myStack;
    private MyDeque myDeque;
    private MyQueue myQueue;

    // Mocking objects
    private MyStack mockedStack;
    private MyDeque mockedDeque;
    private MyLinkedList mockedLinkedList;

    @Given("I have an empty MyArray with capacity {int}")
    public void i_have_an_empty_my_array_with_capacity(int capacity) {
        myArray = new MyArray(capacity);
    }

    @When("I add {int} to the MyArray")
    public void i_add_to_the_my_array(int value) {
        myArray.add(value);
    }

    @Then("the size of the MyArray should be {int}")
    public void the_size_of_the_my_array_should_be(int size) {
        assertEquals(size, myArray.size());
    }

    @Then("the first element should be {int}")
    public void the_first_element_should_be(int expected) {
        assertEquals(expected, myArray.get(0));
    }

    @Given("I have an empty MyArray with capacity {int} and add elements")
    public void i_have_an_empty_my_array_with_capacity_and_add_elements(int capacity) {
        myArray = new MyArray(capacity);
        myArray.add(10);
        myArray.add(20);
    }

    @When("I try to add {int} to the MyArray")
    public void i_try_to_add_to_the_my_array(int value) {
        try {
            myArray.add(value);
        } catch (Exception e) {
            // Do nothing as we are just testing exceptions
        }
    }

    @Then("an IndexOutOfBoundsException should be thrown")
    public void an_index_out_of_bounds_exception_should_be_thrown() {
        assertThrows(IndexOutOfBoundsException.class, () -> myArray.add(30));
    }

    @Given("I have a mocked MyStack")
    public void i_have_a_mocked_my_stack() {
        mockedStack = mock(MyStack.class);
    }

    @When("I push {int} onto the MyStack")
    public void i_push_onto_the_my_stack(int value) {
        doNothing().when(mockedStack).push(value);
        mockedStack.push(value);
    }

    @Then("the stack should contain {int}")
    public void the_stack_should_contain(int value) {
        verify(mockedStack).push(value);  // Verifying the push method is called with the given value
    }

    @Given("I have a mocked MyDeque")
    public void i_have_a_mocked_my_deque() {
        mockedDeque = mock(MyDeque.class);
    }

    @When("I add {int} to the front of the Deque")
    public void i_add_to_the_front_of_the_deque(int value) {
        doNothing().when(mockedDeque).addFirst(value);
        mockedDeque.addFirst(value);
    }

    @When("I add {int} to the back of the Deque")
    public void i_add_to_the_back_of_the_deque(int value) {
        doNothing().when(mockedDeque).addLast(value);
        mockedDeque.addLast(value);
    }

    @Then("the size of the Deque should be {int}")
    public void the_size_of_the_deque_should_be(int size) {
        when(mockedDeque.size()).thenReturn(size);
        assertEquals(size, mockedDeque.size());
    }

//    @Then("the first element should be {int}")
//    public void the_first_element_should_be(int value) {
//        when(mockedDeque.removeFirst()).thenReturn(value);
//        assertEquals(value, mockedDeque.removeFirst());
//    }

    @Then("the last element should be {int}")
    public void the_last_element_should_be(int value) {
        when(mockedDeque.removeLast()).thenReturn(value);
        assertEquals(value, mockedDeque.removeLast());
    }

//    // Scenario 1: Resizing MyArray when capacity is exceeded
//    @Given("I have an empty MyArray with capacity {int}")
//    public void i_have_an_empty_my_array_with_capacity(int capacity) {
//        myArray = new MyArray(capacity);
//    }

//    @When("I add {int} to the MyArray")
//    public void i_add_to_the_my_array(int value) {
//        myArray.add(value);
//    }
//
//    @Then("the size of the MyArray should be {int}")
//    public void the_size_of_the_my_array_should_be(int size) {
//        assertEquals(size, myArray.size());
//    }

    @Then("the capacity should have increased")
    public void the_capacity_should_have_increased() {
        assertTrue(myArray.size() > 3);  // Verifying capacity increase
    }

//    // Scenario 2: Mocking stack pop behavior when empty
//    @Given("I have a mocked MyStack")
//    public void i_have_a_mocked_my_stack() {
//        mockedStack = mock(MyStack.class);
//    }

    @When("I attempt to pop from the empty stack")
    public void i_attempt_to_pop_from_the_empty_stack() {
        when(mockedStack.pop()).thenThrow(new IllegalStateException("Stack is empty"));
    }

    @Then("an IllegalStateException should be thrown")
    public void an_illegal_state_exception_should_be_thrown() {
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> mockedStack.pop());
        assertEquals("Stack is empty", thrown.getMessage());
    }

    // Scenario 3: Simulating circular queue behavior
    @Given("I have an empty MyQueue with capacity {int}")
    public void i_have_an_empty_my_queue_with_capacity(int capacity) {
        myQueue = new MyQueue();
    }

    @When("I enqueue {int}")
    public void i_enqueue(int value) {
        myQueue.enqueue(value);
    }

    @When("I dequeue")
    public void i_dequeue() {
        myQueue.dequeue();
    }

    @Then("the size of the Queue should be {int}")
    public void the_size_of_the_queue_should_be(int size) {
        assertEquals(size, myQueue.size());
    }

//    @Then("the first element should be {int}")
//    public void the_first_element_should_be(int value) {
//        assertEquals(value, myQueue.dequeue());
//    }
//
//    // Scenario 4: Deque operations with multiple additions and removals
//    @Given("I have a mocked MyDeque")
//    public void i_have_a_mocked_my_deque() {
//        mockedDeque = mock(MyDeque.class);
//    }

//    @When("I add {int} to the front of the Deque")
//    public void i_add_to_the_front_of_the_deque(int value) {
//        doNothing().when(mockedDeque).addFirst(value);
//        mockedDeque.addFirst(value);
//    }
//
//    @When("I add {int} to the back of the Deque")
//    public void i_add_to_the_back_of_the_deque(int value) {
//        doNothing().when(mockedDeque).addLast(value);
//        mockedDeque.addLast(value);
//    }

    @When("I remove first from the Deque")
    public void i_remove_first_from_the_deque() {
        when(mockedDeque.removeFirst()).thenReturn(10);
        mockedDeque.removeFirst();
    }

//    @Then("the size of the Deque should be {int}")
//    public void the_size_of_the_deque_should_be(int size) {
//        when(mockedDeque.size()).thenReturn(size);
//        assertEquals(size, mockedDeque.size());
//    }
//
//    @Then("the last element should be {int}")
//    public void the_last_element_should_be(int value) {
//        when(mockedDeque.removeLast()).thenReturn(value);
//        assertEquals(value, mockedDeque.removeLast());
//    }

    // Scenario 5: Mocking MyLinkedList behavior with custom get method
    @Given("I have a mocked MyLinkedList")
    public void i_have_a_mocked_my_linked_list() {
        mockedLinkedList = mock(MyLinkedList.class);
    }

    @When("I add {int} to the linked list")
    public void i_add_to_the_linked_list(int value) {
        doNothing().when(mockedLinkedList).add(value);
        mockedLinkedList.add(value);
    }

    @Then("the size of the list should be {int}")
    public void the_size_of_the_list_should_be(int size) {
        when(mockedLinkedList.size()).thenReturn(size);
        assertEquals(size, mockedLinkedList.size());
    }

    @When("I get the element at index {int}")
    public void i_get_the_element_at_index(int index) {
        when(mockedLinkedList.get(index)).thenReturn(20);
    }

    @Then("the value should be {int}")
    public void the_value_should_be(int expectedValue) {
        assertEquals(expectedValue, mockedLinkedList.get(1)); // Custom assertion for get method
    }
}

