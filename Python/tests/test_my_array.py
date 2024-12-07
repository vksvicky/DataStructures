import unittest
from src.my_array import MyArray

class TestMyArray(unittest.TestCase):

    def setUp(self):
        self.array = MyArray(3)

    def test_add_element(self):
        self.array.add(1)
        self.assertEqual(self.array.size(), 1)

    def test_get_element(self):
        self.array.add(1)
        self.assertEqual(self.array.get(0), 1)

    def test_add_element_beyond_capacity(self):
        self.array.add(1)
        self.array.add(2)
        self.array.add(3)
        with self.assertRaises(IndexError):
            self.array.add(4)

    def test_get_element_out_of_bounds(self):
        self.array.add(1)
        with self.assertRaises(IndexError):
            self.array.get(2)

if __name__ == "__main__":
    unittest.main()
