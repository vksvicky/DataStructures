//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../../header/MyLinkedList.h"
#include <gtest/gtest.h>


TEST(MyLinkedListTest, Initialization) {
    MyLinkedList list;
    EXPECT_EQ(list.getSize(), 0);
}

TEST(MyLinkedListTest, AppendElements) {
    MyLinkedList list;
    list.append(10);
    list.append(20);
    EXPECT_EQ(list.getSize(), 2);
    EXPECT_EQ(list.getAt(0), 10);
    EXPECT_EQ(list.getAt(1), 20);
}

TEST(MyLinkedListTest, PrependElements) {
    MyLinkedList list;
    list.prepend(10);
    list.prepend(20);
    EXPECT_EQ(list.getSize(), 2);
    EXPECT_EQ(list.getAt(0), 20);
    EXPECT_EQ(list.getAt(1), 10);
}

TEST(MyLinkedListTest, RemoveElements) {
    MyLinkedList list;
    list.append(10);
    list.append(20);
    list.removeAt(0);
    EXPECT_EQ(list.getSize(), 1);
    EXPECT_EQ(list.getAt(0), 20);
}
