package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;  
import org.junit.jupiter.api.BeforeEach;

class StackTest {

    private Stack stack;

    //Test for the stack functions
    @BeforeEach

    void setUp() {
        stack = new Stack(10);
    }
    
    @Test
    void testTop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.top());
    }

    @Test
    void testPush() {
        stack.push(1);
        assertEquals(1, stack.top());
    }

    @Test
    void testPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testMakeNull() {
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.makeNull();
        assertTrue(stack.isEmpty());}
}