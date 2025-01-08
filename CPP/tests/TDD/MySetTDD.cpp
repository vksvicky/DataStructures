//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../../header/MySet.h"
#include <gtest/gtest.h>

// Happy path tests
TEST(MySetTest, AddAndRetrieve) {
    MySet mySet;
    mySet.add(1);
    mySet.add(2);
    EXPECT_TRUE(mySet.exists(1));
    EXPECT_TRUE(mySet.exists(2));
    EXPECT_EQ(mySet.size(), 2);
}

// Negative and exception handling tests
TEST(MySetTest, RemoveNonExistentElement) {
    MySet mySet;
    EXPECT_THROW(mySet.remove(99), std::out_of_range);
}

// Error cases
TEST(MySetTest, DuplicateAdditions) {
    MySet mySet;
    mySet.add(1);
    mySet.add(1); // Duplicate addition
    EXPECT_EQ(mySet.size(), 1);
}

// Big-O performance test
TEST(MySetTest, BigOInsertions) {
    MySet mySet;
    const int N = 10000;

    for (int i = 0; i < N; ++i) {
        mySet.add(i);
    }

    EXPECT_EQ(mySet.size(), N);
    for (int i = 0; i < N; ++i) {
        EXPECT_TRUE(mySet.exists(i));
    }
}
