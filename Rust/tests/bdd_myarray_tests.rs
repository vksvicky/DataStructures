#[cfg(test)]
mod bdd_myarray_tests {
    use rspec::describe;
    use rust_data_structures::myarray::MyArray;

    #[test]
    fn bdd_myarray_behaviors() {
        describe("MyArray", (), move |ctx| {
            ctx.it("should add elements within capacity", move |_| {
                let mut array = MyArray::new(3);
                assert!(array.add(10).is_ok());
                assert!(array.add(20).is_ok());
                assert_eq!(array.size(), 2);
            });

            ctx.it("should not add elements beyond capacity", move |_| {
                let mut array = MyArray::new(3);
                array.add(10).unwrap();
                array.add(20).unwrap();
                array.add(30).unwrap();
                assert_eq!(array.add(40), Err("Array capacity exceeded"));
            });

            ctx.it("should retrieve elements by index", move |_| {
                let mut array = MyArray::new(3);
                array.add(10).unwrap();
                array.add(20).unwrap();
                assert_eq!(array.get(0), Ok(10));
                assert_eq!(array.get(1), Ok(20));
            });

            ctx.it("should handle out-of-bounds access gracefully", move |_| {
                let array = MyArray::new(3);
                assert_eq!(array.get(0), Err("Index out of bounds"));
            });
        });
    }
}
