class MyDeque:
    def __init__(self):
        self.deque = []

    def add_first(self, value):
        # Adds an element to the front of the deque
        self.deque.insert(0, value)

    def add_last(self, value):
        # Adds an element to the end of the deque
        self.deque.append(value)

    def remove_first(self):
        # Removes and returns the first element from the deque
        if not self.deque:
            raise IndexError("Deque is empty")
        return self.deque.pop(0)

    def remove_last(self):
        # Removes and returns the last element from the deque
        if not self.deque:
            raise IndexError("Deque is empty")
        return self.deque.pop()

    def size(self):
        # Returns the size of the deque
        return len(self.deque)
