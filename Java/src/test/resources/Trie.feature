Feature: Trie functionality

  Scenario: Insert and search for words
    Given an empty MyTrie
    When I insert "apple" and "app" into the trie
    Then searching for "apple" should return true
    And searching for "app" should return true

  Scenario: Search for a non-existent word
    Given a MyTrie with the word "apple"
    When I search for "banana"
    Then it should return false

  Scenario: Check if a prefix exists
    Given a MyTrie with the word "apple"
    When I check if the prefix "app" exists
    Then it should return true

  Scenario: Check a non-existent prefix
    Given a MyTrie with the word "apple"
    When I check if the prefix "ban" exists
    Then it should return false

  Scenario: Insert a null word
    Given an empty MyTrie
    When I insert a null word
    Then an exception should be thrown with the message "Invalid word: Cannot insert null or empty word"

  Scenario: Search for a null word
    Given an empty MyTrie
    When I search for a null word
    Then an exception should be thrown with the message "Invalid word: Cannot search null or empty word"

  Scenario: Check a null prefix
    Given an empty MyTrie
    When I check a null prefix
    Then an exception should be thrown with the message "Invalid prefix: Cannot check null or empty prefix"