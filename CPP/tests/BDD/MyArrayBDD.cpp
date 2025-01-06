//
// Created by Vivek Krishnan on 20/12/2024.
//

#include <catch2/catch_test_macros.hpp>
#include "../../header/MyArray.h"

SCENARIO("Array Operations", "[array]") {
    GIVEN("A new MyArray") {
        MyArray arr;

        WHEN("Setting the first element to 10") {
            arr[0] = 10;

            THEN("The first element should be 10") {
                REQUIRE(arr[0] == 10);
            }
        }

        AND_WHEN("Accessing an out-of-bounds index") {
            THEN("It should throw an out_of_range exception") {
                REQUIRE_THROWS_AS(arr.at(5), std::out_of_range);
            }
        }
    }
}
