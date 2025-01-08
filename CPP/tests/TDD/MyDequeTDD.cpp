//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../../header/MyDeque.h"
#include <gtest/gtest.h>

// Happy path tests
TEST(MyDequeTest, PushAndPopOperations) {
    MyDeque deque;
    deque.pushFront(10);
    deque.pushBack(20);
    EXPECT_EQ(deque.getSize(), 2);
    EXPECT_EQ(deque.getFront(), 10);
    EXPECT_EQ(deque.getRear(), 20);

    EXPECT_EQ(deque.popFront(), 10);
    EXPECT_EQ(deque.popBack(), 20);
    EXPECT_TRUE(deque.isEmpty());
}

// Negative and exception handling tests
TEST(MyDequeTest, UnderflowError) {
    MyDeque deque;
    EXPECT_THROW(deque.popFront(), std::underflow_error);
    EXPECT_THROW(deque.popBack(), std::underflow_error);
}

// Big-O performance test (example)
TEST(MyDequeTest, BigOTest) {
    MyDeque deque;
    const int N = 10000;
    for (int i = 0; i < N; ++i) {
        deque.pushBack(i);
    }
    EXPECT_EQ(deque.getSize(), N);
    for (int i = 0; i < N; ++i) {
        deque.popFront();
    }
    EXPECT_TRUE(deque.isEmpty());
}
