package org.example;


public class Calculator {
    public double evaluate(String expression) {
        Stack stack = new Stack(20);
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                if (stack.isEmpty()) throw new RuntimeException("Faltan operandos");

                double b = stack.pop();
                if (stack.isEmpty()) throw new RuntimeException("Faltan operandos");

                double a = stack.pop();
                double result = 0;

                switch (token) {
                    case "+" -> result = a + b;
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> {
                        if (b == 0) throw new ArithmeticException("División por cero");
                        result = a / b;
                    }
                    default -> throw new RuntimeException("Invalid input");
                }
                stack.push(result);
            }
        }
        double result = stack.pop();
        if (!stack.isEmpty()) {
            throw new RuntimeException("Invalid expression");
        }
        return result;
    }

    private boolean isNumber(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }
    
}
