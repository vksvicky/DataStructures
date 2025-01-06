//
// Created by Vivek Krishnan on 20/12/2024.
//

#include "../../header/MyStack.h"
#include <catch2/catch_test_macros.hpp>

// Scenario: Pushing and popping elements
TEST_CASE("Pushing and popping elements", "[MyStackBDD]") {
    // Given an empty stack
    MyStack stack;

    // When elements are pushed onto the stack
    stack.push(1);
    stack.push(2);

    // Then the size should increase
    REQUIRE(stack.size() == 2);

    // And the top element should be 2
    REQUIRE(stack.peek() == 2);

    // When the top element is popped
    int popped = stack.pop();

    // Then the popped element should be 2
    REQUIRE(popped == 2);

    // And the size should decrease
    REQUIRE(stack.size() == 1);
}

// Scenario: Handling stack overflow and underflow
TEST_CASE("Handling stack overflow and underflow", "[MyStackBDD]") {
    // Given a stack with maximum capacity
    MyStack stack;
    for (size_t i = 0; i < 100; ++i) {
        stack.push(i);
    }

    // When pushing beyond capacity
    // Then an overflow error should be thrown
    REQUIRE_THROWS_AS(stack.push(101), std::overflow_error);

    // When popping all elements
    for (size_t i = 0; i < 100; ++i) {
        stack.pop();
    }

    // Then the stack should be empty
    REQUIRE(stack.empty());

    // And an underflow error should be thrown if popping again
    REQUIRE_THROWS_AS(stack.pop(), std::underflow_error);
}
