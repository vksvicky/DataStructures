//
// Created by Vivek Krishnan on 06/01/2025.
//

#include "../../header/MyStack.h"
#include <gtest/gtest.h>

// Test stack initialization
TEST(MyStackTDD, Initialization) {
    MyStack stack;
    EXPECT_TRUE(stack.empty());
    EXPECT_EQ(stack.size(), 0);
}

// Test push operation
TEST(MyStackTDD, Push) {
    MyStack stack;
    stack.push(42);
    EXPECT_FALSE(stack.empty());
    EXPECT_EQ(stack.peek(), 42);
    EXPECT_EQ(stack.size(), 1);
}

// Test pop operation
TEST(MyStackTDD, Pop) {
    MyStack stack;
    stack.push(10);
    stack.push(20);
    EXPECT_EQ(stack.pop(), 20);
    EXPECT_EQ(stack.pop(), 10);
    EXPECT_TRUE(stack.empty());
}

// Test peek operation
TEST(MyStackTDD, Peek) {
    MyStack stack;
    stack.push(5);
    EXPECT_EQ(stack.peek(), 5);
    EXPECT_EQ(stack.size(), 1);
}

// Test stack overflow
TEST(MyStackTDD, Overflow) {
    MyStack stack;
    for (size_t i = 0; i < 100; ++i) {
        stack.push(i);
    }
    EXPECT_THROW(stack.push(101), std::overflow_error);
}

// Test stack underflow
TEST(MyStackTDD, Underflow) {
    MyStack stack;
    EXPECT_THROW(stack.pop(), std::underflow_error);
    EXPECT_THROW(stack.peek(), std::underflow_error);
}
