//
// Created by Vivek Krishnan on 20/12/2024.
//

#include "../../header/MyStack.h"
#include <gtest/gtest.h>

// Scenario: Pushing and popping elements
TEST(MyStackBDD, PushPopScenario) {
    // Given an empty stack
    MyStack stack;

    // When elements are pushed onto the stack
    stack.push(1);
    stack.push(2);

    // Then the size should increase
    EXPECT_EQ(stack.size(), 2);

    // And the top element should be 2
    EXPECT_EQ(stack.peek(), 2);

    // When the top element is popped
    int popped = stack.pop();

    // Then the popped element should be 2
    EXPECT_EQ(popped, 2);

    // And the size should decrease
    EXPECT_EQ(stack.size(), 1);
}

// Scenario: Handling stack overflow and underflow
TEST(MyStackBDD, OverflowUnderflowScenario) {
    // Given a stack with maximum capacity
    MyStack stack;
    for (size_t i = 0; i < 100; ++i) {
        stack.push(i);
    }

    // When pushing beyond capacity
    // Then an overflow error should be thrown
    EXPECT_THROW(stack.push(101), std::overflow_error);

    // When popping all elements
    for (size_t i = 0; i < 100; ++i) {
        stack.pop();
    }

    // Then the stack should be empty
    EXPECT_TRUE(stack.empty());

    // And an underflow error should be thrown if popping again
    EXPECT_THROW(stack.pop(), std::underflow_error);
}
