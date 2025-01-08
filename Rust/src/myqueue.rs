// MyQueue implementation
#[derive(Debug, Clone)]
pub struct MyQueue {
    elements: Vec<i32>,
}

impl MyQueue {
    pub fn new() -> Self {
        MyQueue { elements: Vec::new() }
    }

    pub fn enqueue(&mut self, value: i32) {
        self.elements.push(value);
    }

    pub fn dequeue(&mut self) -> Result<i32, &'static str> {
        if self.elements.is_empty() {
            Err("Queue underflow")
        } else {
            Ok(self.elements.remove(0))
        }
    }

    pub fn peek(&self) -> Result<i32, &'static str> {
        self.elements.first().cloned().ok_or("Queue is empty")
    }

    pub fn size(&self) -> usize {
        self.elements.len()
    }
}
