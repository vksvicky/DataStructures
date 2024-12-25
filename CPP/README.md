cmake --build cmake-build-debug --clean-first
cmake --build .
cmake --build . --target MyArrayTDD
./MyArrayTDD

cmake --build . --target MyArrayBDD
./MyArrayBDD

./MyArrayMain