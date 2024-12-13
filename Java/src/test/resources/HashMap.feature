Feature: MyHashMap functionality

  Scenario: Add and retrieve a key-value pair
    Given an empty MyHashMap
    When I add a key "Key1" with value "Value1"
    Then the map should return "Value1" for "Key1"

  Scenario: Override a value for an existing key
    Given a MyHashMap with key "Key1" and value "Value1"
    When I update the key "Key1" with value "NewValue"
    Then the map should return "NewValue" for "Key1"

  Scenario: Remove a key
    Given a MyHashMap with key "Key1" and value "Value1"
    When I remove the key "Key1"
    Then the map should not contain "Key1"

  Scenario: Handle null keys
    Given an empty MyHashMap
    When I add a null key
    Then an exception should be thrown with message "Key cannot be null"
