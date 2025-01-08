//
// Created by Vivek Krishnan on 08/01/2025.
//

#include "../../header/MySet.h"
#include <catch2/catch_test_macros.hpp>

SCENARIO("Using MySet to manage unique elements", "[BDD]") {
    GIVEN("An empty set") {
        MySet mySet;

        THEN("It should be empty initially") {
            REQUIRE(mySet.isEmpty());
        }

        WHEN("Adding unique elements to the set") {
            mySet.add(1);
            mySet.add(2);

            THEN("The size should increase and elements should be retrievable") {
                REQUIRE(mySet.size() == 2);
                REQUIRE(mySet.exists(1));
                REQUIRE(mySet.exists(2));
            }
        }

        WHEN("Attempting to add duplicate elements") {
            mySet.add(1);
            mySet.add(1);

            THEN("The size should not increase") {
                REQUIRE(mySet.size() == 1);
            }
        }

        WHEN("Removing an element") {
            mySet.add(1);
            mySet.remove(1);

            THEN("The element should no longer exist") {
                REQUIRE_FALSE(mySet.exists(1));
                REQUIRE(mySet.size() == 0);
            }
        }

        WHEN("Removing a non-existent element") {
            THEN("An exception should be thrown") {
                REQUIRE_THROWS_AS(mySet.remove(99), std::out_of_range);
            }
        }

        WHEN("Clearing all elements in the set") {
            mySet.add(1);
            mySet.add(2);
            mySet.clear();

            THEN("The set should be empty") {
                REQUIRE(mySet.isEmpty());
            }
        }
    }
}
