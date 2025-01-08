#[cfg(test)]
mod bdd_myqueue_tests {
    use rspec::*;
    use rust_data_structures::myqueue::MyQueue;

    #[test]
    fn bdd_myqueue_behaviors() {
        let queue = MyQueue::new();
        describe("MyQueue", queue, |ctx| {
            ctx.it("should enqueue and dequeue elements correctly", |_| {
                let mut q = MyQueue::new();
                q.enqueue(10);
                q.enqueue(20);
                assert_eq!(q.dequeue(), Ok(10));
                assert_eq!(q.dequeue(), Ok(20));
            });

            ctx.it("should return error on dequeue from empty queue", |_| {
                let mut q = MyQueue::new();
                assert_eq!(q.dequeue(), Err("Queue underflow"));
            });
        });
    }
}
