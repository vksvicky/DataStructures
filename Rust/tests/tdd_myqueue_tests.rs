#[cfg(test)]
mod tdd_myqueue_tests {
    use rust_data_structures::myqueue::MyQueue;

    #[test]
    fn test_enqueue_dequeue_happy_path() {
        let mut queue = MyQueue::new();
        queue.enqueue(10);
        queue.enqueue(20);
        assert_eq!(queue.dequeue(), Ok(10));
        assert_eq!(queue.dequeue(), Ok(20));
    }

    #[test]
    fn test_dequeue_empty_queue() {
        let mut queue = MyQueue::new();
        assert_eq!(queue.dequeue(), Err("Queue underflow"));
    }

    #[test]
    fn test_peek_empty_queue() {
        let queue = MyQueue::new();
        assert_eq!(queue.peek(), Err("Queue is empty"));
    }
}
