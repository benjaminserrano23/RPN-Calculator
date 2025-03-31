package org.example;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testRPNExpression() {
        String input = "3 4 + 2 * 7 /"; //simulates user input
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(new String[0]);
        String output = out.toString()
        
        assertTrue(output.contains("Result: 2.0")); //check if the output contains the expected result
    }
    @Test
    void testInvalidRPNExpression() {
        String input = "3 4 + 2 * 7 / 5"; //simulates user input
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); 
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out)); 
        Main.main(new String[0]); //call the main method of the Main class
        String output = out.toString();
        
        assertTrue(output.contains("Invalid RPN expression")); //check if the output contains the expected error message
    }
    @Test
    void testInvalidInput() {
        String input = "3 4 + a"; //simulates user input
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(new String[0]);
        String output = out.toString(); 
        
        assertTrue(output.contains("Invalid input")); //check if the output contains the expected error message
    }
    @Test
    void testDivisionByZero() {
        String input = "6 0 /"; //simulates user input
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(new String[0]);
        String output = out.toString(); 
        
        assertTrue(output.contains("Division by zero")); //check if the output contains the expected error message
    }
}