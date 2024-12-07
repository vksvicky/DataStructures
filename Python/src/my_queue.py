class MyQueue:
    def __init__(self, capacity):
        self.capacity = capacity
        self.queue = []

    def enqueue(self, value):
        # Adds an element to the back of the queue
        if len(self.queue) >= self.capacity:
            raise OverflowError("Queue is full")
        self.queue.append(value)

    def dequeue(self):
        # Removes and returns the front element of the queue
        if not self.queue:
            raise IndexError("Queue is empty")
        return self.queue.pop(0)

    def size(self):
        # Returns the size of the queue
        return len(self.queue)
