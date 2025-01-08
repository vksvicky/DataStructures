#[cfg(test)]
mod bdd_mystack_tests {
    use rspec::*;
    use rust_data_structures::mystack::MyStack;

    #[test]
    fn bdd_mystack_behaviors() {
        let stack = MyStack::new();
        describe("MyStack", stack, |ctx| {
            ctx.it("should push and pop elements correctly", move |_| {
                let mut stack = MyStack::new();
                stack.push(10);
                stack.push(20);
                assert_eq!(stack.pop(), Ok(20));
                assert_eq!(stack.pop(), Ok(10));
            });

            ctx.it("should return error on pop from empty stack", move |_| {
                let mut stack = MyStack::new();
                assert_eq!(stack.pop(), Err("Stack underflow"));
            });
        });
    }
}
