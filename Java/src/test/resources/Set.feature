Feature: Set functionality

  Scenario: Add an element to the set
    Given an empty MySet
    When I add "Element1" to the set
    Then the set should contain "Element1"

  Scenario: Prevent duplicate elements
    Given a MySet with "Element1"
    When I add "Element1" again
    Then the size of the set should be 1

  Scenario: Remove an element from the set
    Given a MySet with "Element1"
    When I remove "Element1"
    Then the set should not contain "Element1"

  Scenario: Check if the set is empty
    Given an empty MySet
    Then the set should be empty

  Scenario: Add null element
    Given an empty MySet
    When I add a null element
    Then an exception should be thrown with message "Element cannot be null"
