Feature: MyHeap Operations

  Scenario: Insert elements into the heap
    Given the heap is empty
    When I insert 10 into the heap
    And I insert 20 into the heap
    And I insert 5 into the heap
    Then the minimum element should be 5

  Scenario: Extract the minimum element from the heap
    Given the heap contains 10, 20, and 5
    When I extract the minimum element
    Then the extracted element should be 5
    And the new minimum element should be 10

  Scenario: Attempt to extract from an empty heap
    Given the heap is empty
    When I try to extract the minimum element
    Then I should receive an error "Heap is empty"

  Scenario: Peek into the heap
    Given the heap contains 10, 20, and 5
    When I peek into the heap
    Then the minimum element should be 5

  Scenario: Heapify an unsorted array
    Given the heap is empty
    When I heapify the array [10, 20, 5, 30, 15]
    Then the minimum element should be 5