class MyArray:
    def __init__(self, capacity):
        # Initialize an array with given capacity
        self.capacity = capacity
        self.arr = []

    def add(self, value):
        # Adds a value to the array if there is space
        if len(self.arr) >= self.capacity:
            raise IndexError("Array is full!")
        self.arr.append(value)

    def get(self, index):
        # Gets the element at the given index
        if index >= len(self.arr):
            raise IndexError("Index out of bounds")
        return self.arr[index]

    def size(self):
        # Returns the size of the array
        return len(self.arr)
