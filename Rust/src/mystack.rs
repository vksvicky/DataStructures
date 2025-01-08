// MyStack implementation
#[derive(Debug, Clone)]
pub struct MyStack {
    elements: Vec<i32>,
}

impl MyStack {
    pub fn new() -> Self {
        MyStack { elements: Vec::new() }
    }

    pub fn push(&mut self, value: i32) {
        self.elements.push(value);
    }

    pub fn pop(&mut self) -> Result<i32, &'static str> {
        self.elements.pop().ok_or("Stack underflow")
    }

    pub fn peek(&self) -> Result<i32, &'static str> {
        self.elements.last().cloned().ok_or("Stack is empty")
    }

    pub fn size(&self) -> usize {
        self.elements.len()
    }
}
