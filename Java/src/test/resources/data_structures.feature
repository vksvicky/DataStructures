Feature: Advanced testing of data structures with BDD and Mockito

  # Scenario 1: Testing the resizing behavior of MyArray
  Scenario: Resizing MyArray when capacity is exceeded
    Given I have an empty MyArray with capacity 3
    When I add 1 to the MyArray
    And I add 2 to the MyArray
    And I add 3 to the MyArray
    And I add 4 to the MyArray
    Then the size of the MyArray should be 4
    And the capacity should have increased

  # Scenario 2: Mocking the behavior of MyStack and checking the exception
  Scenario: Mocking stack pop behavior when empty
    Given I have a mocked MyStack
    When I attempt to pop from the empty stack
    Then an IllegalStateException should be thrown

  # Scenario 3: Simulating circular queue behavior
  Scenario: Circular Queue behavior with wraparound
    Given I have an empty MyQueue with capacity 3
    When I enqueue 1
    And I enqueue 2
    And I enqueue 3
    And I dequeue
    And I enqueue 4
    Then the size of the Queue should be 3
    And the first element should be 2

  # Scenario 4: Handling multiple operations on Deque
  Scenario: Deque operations with multiple additions and removals
    Given I have a mocked MyDeque
    When I add 10 to the front of the Deque
    And I add 20 to the back of the Deque
    And I remove first from the Deque
    Then the size of the Deque should be 1
    And the last element should be 20

  # Scenario 5: Mocking the behavior of MyLinkedList and testing custom behavior
  Scenario: Mocking MyLinkedList behavior with custom get method
    Given I have a mocked MyLinkedList
    When I add 10 to the linked list
    And I add 20 to the linked list
    Then the size of the list should be 2
    And when I get the element at index 1
    Then the value should be 20
