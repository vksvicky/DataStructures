//
// Created by Vivek Krishnan on 20/12/2024.
//

#include "../../header/MyQueue.h"
#include <gtest/gtest.h>

// Scenario: Enqueuing elements into the queue
TEST(MyQueueBDD, EnqueueScenario) {
    // Given an empty queue
    MyQueue queue;

    // When elements are enqueued
    queue.enqueue(5);
    queue.enqueue(10);

    // Then the size should reflect the number of elements
    EXPECT_EQ(queue.size(), 2);

    // And the front element should be the first enqueued element
    EXPECT_EQ(queue.peek(), 5);
}

// Scenario: Dequeuing elements from the queue
TEST(MyQueueBDD, DequeueScenario) {
    // Given a queue with multiple elements
    MyQueue queue;
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    // When an element is dequeued
    int dequeued = queue.dequeue();

    // Then the dequeued element should be the first enqueued element
    EXPECT_EQ(dequeued, 1);

    // And the size should decrease
    EXPECT_EQ(queue.size(), 2);

    // And the front element should update to the next in line
    EXPECT_EQ(queue.peek(), 2);
}

// Scenario: Handling queue overflow
TEST(MyQueueBDD, OverflowScenario) {
    // Given a queue that reaches maximum capacity
    MyQueue queue;
    for (size_t i = 0; i < 100; ++i) {
        queue.enqueue(i);
    }

    // When trying to enqueue beyond the maximum capacity
    // Then an overflow exception should be thrown
    EXPECT_THROW(queue.enqueue(101), std::overflow_error);
}

// Scenario: Handling queue underflow
TEST(MyQueueBDD, UnderflowScenario) {
    // Given an empty queue
    MyQueue queue;

    // When trying to dequeue from an empty queue
    // Then an underflow exception should be thrown
    EXPECT_THROW(queue.dequeue(), std::underflow_error);

    // And when trying to peek into an empty queue
    // Then an underflow exception should also be thrown
    EXPECT_THROW(queue.peek(), std::underflow_error);
}

// Scenario: Circular behavior of the queue
TEST(MyQueueBDD, CircularBehaviorScenario) {
    // Given a queue that becomes full
    MyQueue queue;
    for (size_t i = 0; i < 100; ++i) {
        queue.enqueue(i);
    }

    // When elements are dequeued to create space
    for (size_t i = 0; i < 10; ++i) {
        EXPECT_EQ(queue.dequeue(), i);
    }

    // And new elements are enqueued
    for (size_t i = 100; i < 110; ++i) {
        queue.enqueue(i);
    }

    // Then the queue should maintain correct order
    EXPECT_EQ(queue.peek(), 10);
    for (size_t i = 10; i < 110; ++i) {
        EXPECT_EQ(queue.dequeue(), i);
    }

    // And the queue should be empty after all elements are dequeued
    EXPECT_TRUE(queue.empty());
}

// Scenario: Enqueue and dequeue multiple elements
TEST(MyQueueBDD, EnqueueDequeueMultipleScenario) {
    // Given an empty queue
    MyQueue queue;

    // When multiple elements are enqueued
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);

    // Then the size should reflect the total elements
    EXPECT_EQ(queue.size(), 3);

    // And the front element should be the first enqueued
    EXPECT_EQ(queue.peek(), 20);

    // When elements are dequeued one by one
    EXPECT_EQ(queue.dequeue(), 20);
    EXPECT_EQ(queue.dequeue(), 30);
    EXPECT_EQ(queue.dequeue(), 40);

    // Then the queue should be empty
    EXPECT_TRUE(queue.empty());

    // And dequeuing again should throw an underflow exception
    EXPECT_THROW(queue.dequeue(), std::underflow_error);
}

