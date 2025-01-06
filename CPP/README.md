cmake --build cmake-build-debug --clean-first
cmake --build .
cmake --build . --target MyArrayTDD
./MyArrayTDD

cmake --build . --target MyArrayBDD
./MyArrayBDD

./MyArrayMain


Build the Project
rm -rf build && mkdir build && cd build && cmake .. && cmake --build .

Cmd to run only tests - TDD
cmake --build . --target run_all_tests