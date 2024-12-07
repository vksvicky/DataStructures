class MyLinkedList:
    class Node:
        def __init__(self, value):
            self.value = value
            self.next = None

    def __init__(self):
        self.head = None

    def add(self, value):
        # Adds a new node with the given value to the list
        new_node = self.Node(value)
        new_node.next = self.head
        self.head = new_node

    def get(self, index):
        # Gets the value of the node at the given index
        current = self.head
        count = 0
        while current:
            if count == index:
                return current.value
            current = current.next
            count += 1
        raise IndexError("Index out of bounds")

    def size(self):
        # Returns the size of the linked list
        count = 0
        current = self.head
        while current:
            count += 1
            current = current.next
        return count
