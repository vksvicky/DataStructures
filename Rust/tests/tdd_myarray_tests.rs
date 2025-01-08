#[cfg(test)]
mod tdd_myarray_tests {
    use rust_data_structures::myarray::MyArray;

    #[test]
    fn test_add_elements_happy_path() {
        let mut array = MyArray::new(3);
        assert!(array.add(10).is_ok());
        assert!(array.add(20).is_ok());
        assert!(array.add(30).is_ok());
    }

    #[test]
    fn test_add_elements_exceeding_capacity() {
        let mut array = MyArray::new(2);
        array.add(10).unwrap();
        array.add(20).unwrap();
        assert_eq!(array.add(30), Err("Array capacity exceeded"));
    }

    #[test]
    fn test_get_elements_happy_path() {
        let mut array = MyArray::new(3);
        array.add(10).unwrap();
        array.add(20).unwrap();
        assert_eq!(array.get(0), Ok(10));
        assert_eq!(array.get(1), Ok(20));
    }

    #[test]
    fn test_get_elements_out_of_bounds() {
        let array = MyArray::new(3);
        assert_eq!(array.get(0), Err("Index out of bounds"));
    }

    #[test]
    fn test_remove_elements_happy_path() {
        let mut array = MyArray::new(3);
        array.add(10).unwrap();
        array.add(20).unwrap();
        assert_eq!(array.size(), 2);
    }
}
