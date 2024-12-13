Feature: PriorityQueue functionality

  Scenario: Add elements to the priority queue
    Given an empty MyPriorityQueue
    When I add 10, 5, and 20 to the queue
    Then the top element should be 5

  Scenario: Poll elements from the priority queue
    Given a MyPriorityQueue with elements 10, 5, and 20
    When I poll an element
    Then the returned element should be 5

  Scenario: Peek the top element of an empty queue
    Given an empty MyPriorityQueue
    When I peek the top element
    Then an exception should be thrown with message "PriorityQueue is empty"

  Scenario: Add a null element to the queue
    Given an empty MyPriorityQueue
    When I add a null element
    Then an exception should be thrown with message "Element cannot be null"
