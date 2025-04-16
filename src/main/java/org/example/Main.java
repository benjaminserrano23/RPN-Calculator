package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los elementos de la expresión RPN separados por espacios:");
        String input = scanner.nextLine().trim();

        if (input.length() < 5) {
            System.out.println("Input too short");
            return;
        }

        if (input.length() > 50) {
            System.out.println("Input too long");
            return;
        }

        Calculator calculator = new Calculator();

        try {
            double result = calculator.evaluate(input);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
        } catch (RuntimeException e) {
            if ("Invalid input".equals(e.getMessage())) {
                System.out.println("Input inválido");
            } else if ("Invalid expression".equals(e.getMessage())) {
                System.out.println("Expresión inválida");
            } else {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}