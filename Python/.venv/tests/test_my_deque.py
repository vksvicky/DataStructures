import unittest
from my_deque import MyDeque

class TestMyDeque(unittest.TestCase):

    def setUp(self):
        self.deque = MyDeque()

    def test_add_first(self):
        self.deque.add_first(1)
        self.assertEqual(self.deque.size(), 1)

    def test_add_last(self):
        self.deque.add_last(1)
        self.assertEqual(self.deque.size(), 1)

    def test_remove_first(self):
        self.deque.add_first(1)
        self.assertEqual(self.deque.remove_first(), 1)
        self.assertEqual(self.deque.size(), 0)

    def test_remove_last(self):
        self.deque.add_last(1)
        self.assertEqual(self.deque.remove_last(), 1)
        self.assertEqual(self.deque.size(), 0)

    def test_remove_from_empty_deque(self):
        with self.assertRaises(IndexError):
            self.deque.remove_first()

if __name__ == "__main__":
    unittest.main()
