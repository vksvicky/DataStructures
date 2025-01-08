# Find Catch2 (or your BDD framework)
find_package(Catch2 3 REQUIRED)

# Include Catch2's CMake helpers
include(CTest)
include(Catch)

# Add test executables for each BDD file
set(BDD_FILES
    MyArrayBDD.cpp
    MyStackBDD.cpp
    MyQueueBDD.cpp
    MyLinkedListBDD.cpp
    MyDequeBDD.cpp
    MyHashMapBDD.cpp
    MySetBDD.cpp
    MyPriorityQueueBDD.cpp
)

foreach(BDD_FILE ${BDD_FILES})
    get_filename_component(TEST_NAME ${BDD_FILE} NAME_WE) # Extract test name (e.g., MyArrayBDD)
    add_executable(${TEST_NAME} ${BDD_FILE})
    target_link_libraries(${TEST_NAME} MyDataStructureLib Catch2::Catch2WithMain)
    catch_discover_tests(${TEST_NAME})
endforeach()

# Custom target to build and run all BDD tests
add_custom_target(run_all_bdd_tests
    COMMAND ${CMAKE_CTEST_COMMAND} --output-on-failure
    DEPENDS ${BDD_FILES}
    COMMENT "Building and running all BDD tests..."
)