//
// Created by Vivek Krishnan on 20/12/2024.
//

#include "../../header/MyArray.h"
#include <gtest/gtest.h>

// Test array size
TEST(MyArrayTDD, Size) {
    MyArray arr;
    EXPECT_EQ(arr.size(), 5);  // The size should be 5
}

// Test element access and modification
TEST(MyArrayTDD, AccessAndModify) {
    MyArray arr;
    arr[0] = 42;
    EXPECT_EQ(arr[0], 42);
    arr.at(1) = 100;
    EXPECT_EQ(arr.at(1), 100);
}

// Test bounds checking
TEST(MyArrayTDD, BoundsChecking) {
    MyArray arr;
    EXPECT_THROW(arr.at(5), std::out_of_range);  // Should throw exception
}

// Test fill function
TEST(MyArrayTDD, Fill) {
    MyArray arr;
    arr.fill(7);
    for (size_t i = 0; i < arr.size(); ++i) {
        EXPECT_EQ(arr[i], 7);  // All elements should be 7
    }
}

// Test empty function
TEST(MyArrayTDD, Empty) {
    MyArray arr;
    EXPECT_TRUE(arr.empty());  // Initially, array should be empty (all elements 0)
    arr[0] = 1;
    EXPECT_FALSE(arr.empty());  // After modifying an element, array should not be empty
}