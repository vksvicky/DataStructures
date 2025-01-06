//
// Created by Vivek Krishnan on 06/01/2025.
//

#include "../../header/MyQueue.h"
#include <gtest/gtest.h>

// Test queue initialization
TEST(MyQueueTDD, Initialization) {
    MyQueue queue;
    EXPECT_TRUE(queue.empty());
    EXPECT_EQ(queue.size(), 0);
}

// Test enqueue operation
TEST(MyQueueTDD, Enqueue) {
    MyQueue queue;
    queue.enqueue(10);
    EXPECT_FALSE(queue.empty());
    EXPECT_EQ(queue.peek(), 10);
    EXPECT_EQ(queue.size(), 1);
}

// Test dequeue operation
TEST(MyQueueTDD, Dequeue) {
    MyQueue queue;
    queue.enqueue(5);
    queue.enqueue(15);
    EXPECT_EQ(queue.dequeue(), 5);
    EXPECT_EQ(queue.dequeue(), 15);
    EXPECT_TRUE(queue.empty());
}

// Test peek operation
TEST(MyQueueTDD, Peek) {
    MyQueue queue;
    queue.enqueue(25);
    EXPECT_EQ(queue.peek(), 25);
    EXPECT_EQ(queue.size(), 1);
}

// Test queue overflow
TEST(MyQueueTDD, Overflow) {
    MyQueue queue;
    for (size_t i = 0; i < 100; ++i) {
        queue.enqueue(i);
    }
    EXPECT_THROW(queue.enqueue(101), std::overflow_error);
}

// Test queue underflow
TEST(MyQueueTDD, Underflow) {
    MyQueue queue;
    EXPECT_THROW(queue.dequeue(), std::underflow_error);
    EXPECT_THROW(queue.peek(), std::underflow_error);
}

