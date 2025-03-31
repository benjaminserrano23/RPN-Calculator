package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    //Test for the calculator functions
    @Test
    void testAdd() {    
        assertEquals(5, calculator.evaluate("2 3 +"));
    }
    @Test
    void testSubstraction() {
        assertEquals(2, calculator.evaluate("3 1 -")); 
    }
    @Test
    void testMultiplication() {
        assertEquals(6, calculator.evaluate("2 3 *"));
    }
    @Test
    void testDivision() {
        assertEquals(2, calculator.evaluate("6 2 /"));
    }
    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.evaluate("6 0 /"));
    }
}