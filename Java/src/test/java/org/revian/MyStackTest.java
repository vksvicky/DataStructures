package org.revian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    private MyStack stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack();
    }

    @Test
    void testPushAndPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPeek() {
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    @Test
    void testPopEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    void testPeekEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }
}
