//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../../header/MyLinkedList.h"
#include <catch2/catch_test_macros.hpp>


SCENARIO("Using MyLinkedList for common operations", "[BDD]") {
    GIVEN("An empty MyLinkedList") {
        MyLinkedList list;

        THEN("The size is zero") {
            REQUIRE(list.getSize() == 0);
        }

        WHEN("An element is appended") {
            list.append(10);

            THEN("The size increases and the element can be retrieved") {
                REQUIRE(list.getSize() == 1);
                REQUIRE(list.getAt(0) == 10);
            }
        }

        WHEN("An element is prepended") {
            list.prepend(20);

            THEN("The size increases and the element is at the beginning") {
                REQUIRE(list.getSize() == 1);
                REQUIRE(list.getAt(0) == 20);
            }
        }

        WHEN("An element is removed") {
            list.append(10);
            list.append(20);
            list.removeAt(1);

            THEN("The size decreases and the correct element is removed") {
                REQUIRE(list.getSize() == 1);
                REQUIRE(list.getAt(0) == 10);
            }
        }
    }
}
