# Find Google Test
find_package(GTest REQUIRED)
include(GoogleTest)
include_directories(${GTEST_INCLUDE_DIRS})

# Add test executables for each TDD file
set(TDD_FILES
    MyArrayTDD.cpp
    MyStackTDD.cpp
    MyQueueTDD.cpp
)

foreach(TDD_FILE ${TDD_FILES})
    get_filename_component(TEST_NAME ${TDD_FILE} NAME_WE) # Extract test name (e.g., MyArrayTDD)
    add_executable(${TEST_NAME} ${TDD_FILE})
    target_link_libraries(${TEST_NAME} MyDataStructureLib GTest::GTest GTest::Main)
    gtest_discover_tests(${TEST_NAME})
endforeach()

# Custom target to build and run all tests
add_custom_target(run_all_tests
    COMMAND ${CMAKE_CTEST_COMMAND} --output-on-failure
    DEPENDS ${TDD_FILES}
    COMMENT "Building and running all tests..."
)
