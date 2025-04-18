package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class MainTest {
    //Test de una expresion compleja válida 
    @Test
    void testRPNExpression() {
        String input = "3 4 + 2 * 7 /"; //simulates user inputs
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(new String[0]);
        String output = out.toString();
        
        assertTrue(output.contains("Result: 2.0")); //check if the output contains the expected result
    }
    //Test de una operación inválida
    @Test
    void testInvalidRPNExpression() {
        String input = "3 4 + 2 * 7 / 5"; //simulates user input
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); 
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out)); 
        Main.main(new String[0]); //call the main method of the Main class
        String output = out.toString();
        assertTrue(output.contains("Expresión inválida")); //check if the output contains the expected error message
    }
    //Test de input inválido (carácter extraño)
    @Test
    void testInvalidInput() {
        String input = "3 4 &"; //simulates user input
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(new String[0]);
        String output = out.toString();
        System.out.println(output); // para debug

        assertTrue(output.contains("Input inválido")); //check if the output contains the expected error message
    }
    //Test división por cero
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
    //Test de números decimales
    @Test
    void testDecimalNumber() {
        String input = "3.5 4.2 +"; //Esperado: 7.7
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[0]);

        String output = out.toString(); 
        
        assertTrue(output.contains("Result: 7.7")); //check if the output contains the expected result
    }
    //Test de input muy corto o pequeño
    @Test
    void testShortInput() {
        String input = "1 +"; // Solo 2 caracteres => muy corto
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[0]);

        String output = out.toString(); 
        
        assertTrue(output.contains("Input too short")); //check if the output contains the expected error message
    }
    //Test de input muy largo
    @Test
    void testLongInput() {
        String input = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 +"; //simulates user input with 24 maximum length
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[0]);
        String output = out.toString(); 
        
        assertTrue(output.contains("Input too long")); //check if the output contains the expected error message
    }
}