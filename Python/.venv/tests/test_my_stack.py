import unittest
from my_stack import MyStack

class TestMyStack(unittest.TestCase):

    def setUp(self):
        self.stack = MyStack()

    def test_push_element(self):
        self.stack.push(1)
        self.assertEqual(self.stack.size(), 1)

    def test_pop_element(self):
        self.stack.push(1)
        self.assertEqual(self.stack.pop(), 1)
        self.assertEqual(self.stack.size(), 0)

    def test_pop_empty_stack(self):
        with self.assertRaises(IndexError):
            self.stack.pop()

if __name__ == "__main__":
    unittest.main()
