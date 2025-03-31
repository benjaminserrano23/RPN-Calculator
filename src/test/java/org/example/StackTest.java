package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class StackTest {
    Private Stack stack;
    //Test for the stack functions
    @BeforeEach
    void setUp() {
        stack = new Stack(10);
    }

    @Test
    void testPush() {
        stack.push(1);
        assertEquals(stack.top(), 1);
    }
    @Test
    void testPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(stack.pop(), 2);
    }
    @Test
    void testTop() {
        stack.push(1);
        stack.push(2);
        assertEquals(stack.top(), 2);
    }
    @Test
    void testMakeNull() {
        stack.push(1);
        assertEquals(makeNull(S), 0);
    }
    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

}