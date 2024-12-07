Feature: Testing MyQueue and MyLinkedList behaviors

  Scenario: Enqueue and Dequeue behavior for MyQueue
    Given I have an empty MyQueue with capacity 3
    When I enqueue 1
    And I enqueue 2
    Then the size of the Queue should be 2
    When I dequeue
    Then the size of the Queue should be 1
    And the first element should be 2

  Scenario: Add and access elements from LinkedList
    Given I have an empty MyLinkedList
    When I add 10
    And I add 20
    Then the size of the LinkedList should be 2
    When I get the element at index 1
    Then the value should be 20
