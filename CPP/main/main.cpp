//
// Created by Vivek Krishnan on 20/12/2024.
//

#include "../header/MyArray.h"
#include <iostream>

int main() {
    MyArray arr;
    arr.fill(3);

    std::cout << "Array elements: ";
    for (size_t i = 0; i < arr.size(); ++i) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;

    return 0;
}