import unittest
from my_queue import MyQueue

class TestMyQueue(unittest.TestCase):

    def setUp(self):
        self.queue = MyQueue(3)

    def test_enqueue_element(self):
        self.queue.enqueue(1)
        self.assertEqual(self.queue.size(), 1)

    def test_dequeue_element(self):
        self.queue.enqueue(1)
        self.assertEqual(self.queue.dequeue(), 1)
        self.assertEqual(self.queue.size(), 0)

    def test_enqueue_beyond_capacity(self):
        self.queue.enqueue(1)
        self.queue.enqueue(2)
        self.queue.enqueue(3)
        with self.assertRaises(OverflowError):
            self.queue.enqueue(4)

    def test_dequeue_empty_queue(self):
        with self.assertRaises(IndexError):
            self.queue.dequeue()

if __name__ == "__main__":
    unittest.main()
