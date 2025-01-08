// MyArray implementation
pub struct MyArray {
    elements: Vec<i32>,
    capacity: usize,
}

impl MyArray {
    pub fn new(capacity: usize) -> Self {
        MyArray {
            elements: Vec::with_capacity(capacity),
            capacity,
        }
    }

    pub fn add(&mut self, value: i32) -> Result<(), &'static str> {
        if self.elements.len() < self.capacity {
            self.elements.push(value);
            Ok(())
        } else {
            Err("Array capacity exceeded")
        }
    }

    pub fn get(&self, index: usize) -> Result<i32, &'static str> {
        if index < self.elements.len() {
            Ok(self.elements[index])
        } else {
            Err("Index out of bounds")
        }
    }

    pub fn size(&self) -> usize {
        self.elements.len()
    }
}
