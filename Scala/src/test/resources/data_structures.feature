Feature: Advanced testing of data structures with BDD and Mockito

  Scenario: Resizing MyArray when capacity is exceeded
    Given I have an empty MyArray with capacity 3
    When I add 1 to the MyArray
    And I add 2 to the MyArray
    And I add 3 to the MyArray
    And I add 4 to the MyArray
    Then the size of the MyArray should be 4
    And the capacity should have increased

  Scenario: Mocking stack pop behavior when empty
    Given I have a mocked MyStack
    When I attempt to pop from the empty stack
    Then an IllegalStateException should be thrown

  Scenario: Circular Queue behavior with wraparound
    Given I have an empty MyQueue with capacity 3
    When I enqueue 1
    And I enqueue 2
    And I enqueue 3
    And I dequeue
    And I enqueue 4
    Then the size of the Queue should be 3
    And the first element should be 2

Feature: Testing MyQueue behavior

  Scenario: Enqueue and Dequeue behavior for MyQueue
    Given I have an empty MyQueue with capacity 3
    When I enqueue 1
    And I enqueue 2
    Then the size of the Queue should be 2
    When I dequeue
    Then the size of the Queue should be 1
    And the first element should be 2

  Scenario: Enqueue beyond capacity should throw an exception
    Given I have an empty MyQueue with capacity 3
    When I enqueue 1
    And I enqueue 2
    And I enqueue 3
    Then an IllegalStateException should be thrown when I enqueue 4

  Scenario: Circular behavior of MyQueue when wrapping around
    Given I have an empty MyQueue with capacity 3
    When I enqueue 1
    And I enqueue 2
    And I dequeue
    And I enqueue 3
    Then the size of the Queue should be 2
    And the first element should be 2