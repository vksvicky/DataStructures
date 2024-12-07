import unittest
from src.my_linked_list import MyLinkedList

class TestMyLinkedList(unittest.TestCase):

    def setUp(self):
        self.linked_list = MyLinkedList()

    def test_add_element(self):
        self.linked_list.add(10)
        self.assertEqual(self.linked_list.size(), 1)

    def test_get_element(self):
        self.linked_list.add(10)
        self.assertEqual(self.linked_list.get(0), 10)

    def test_get_out_of_bounds(self):
        self.linked_list.add(10)
        with self.assertRaises(IndexError):
            self.linked_list.get(1)

    def test_size(self):
        self.linked_list.add(10)
        self.linked_list.add(20)
        self.assertEqual(self.linked_list.size(), 2)

if __name__ == "__main__":
    unittest.main()
