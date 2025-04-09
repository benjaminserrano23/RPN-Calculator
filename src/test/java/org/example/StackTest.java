package org.example;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @org.junit.jupiter.api.Test
    void testMakeNull() {
        Stack stack = new Stack(5);
        stack.push(1);
        assertEquals(makeNull(S), 0);
    }
    @org.junit.jupiter.api.Test
    void testTop() {
        Stack stack = new Stack(5);
        assertEquals(division(6, 3),2);
    }

}