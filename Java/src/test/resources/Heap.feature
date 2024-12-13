Feature: MyHeap functionality

  Scenario: Insert elements into the heap
    Given an empty MyHeap
    When I insert 10, 5, and 20 into the heap
    Then the minimum element should be 5

  Scenario: Remove the minimum element from the heap
    Given a MyHeap with elements 10, 5, and 20
    When I remove the minimum element
    Then the returned element should be 5
    And the new minimum element should be 10

  Scenario: Get the minimum element of an empty heap
    Given an empty MyHeap
    When I get the minimum element
    Then an exception should be thrown with message "Heap is empty"

  Scenario: Insert a null element into the heap
    Given an empty MyHeap
    When I insert a null element
    Then an exception should be thrown with message "Element cannot be null"
