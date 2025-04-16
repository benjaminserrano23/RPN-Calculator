package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    //Test for the calculator functions
    @Test
    void testAdd() {    
        assertEquals(11, calculator.evaluate("2 3 + 4 + 2 +"));
    }
    @Test
    void testSubstraction() {
        assertEquals(9, calculator.evaluate("17 1 - 3 - 4 -")); 
    }
    @Test
    void testMultiplication() {
        assertEquals(48, calculator.evaluate("2 3 * 4 * 2 *"));
    }
    @Test
    void testDivision() {
        assertEquals(3, calculator.evaluate("6 2 /"));
    }
    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.evaluate("6 0 /"));
    }
}