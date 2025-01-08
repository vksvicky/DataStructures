#[cfg(test)]
mod tdd_mystack_tests {
    use rust_data_structures::mystack::MyStack;

    #[test]
    fn test_push_pop_happy_path() {
        let mut stack = MyStack::new();
        stack.push(10);
        stack.push(20);
        assert_eq!(stack.pop(), Ok(20));
        assert_eq!(stack.pop(), Ok(10));
    }

    #[test]
    fn test_pop_empty_stack() {
        let mut stack = MyStack::new();
        assert_eq!(stack.pop(), Err("Stack underflow"));
    }

    #[test]
    fn test_peek_empty_stack() {
        let stack = MyStack::new();
        assert_eq!(stack.peek(), Err("Stack is empty"));
    }
}
