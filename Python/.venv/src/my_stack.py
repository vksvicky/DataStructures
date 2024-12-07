class MyStack:
    def __init__(self):
        self.stack = []

    def push(self, value):
        # Pushes a value onto the stack
        self.stack.append(value)

    def pop(self):
        # Pops the top value from the stack
        if not self.stack:
            raise IndexError("Stack is empty")
        return self.stack.pop()

    def size(self):
        # Returns the size of the stack
        return len(self.stack)
