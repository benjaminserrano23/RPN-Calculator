package org.example;


public class Calculator {
    public double evaluate(String expression) {
        Stack stack = new Stack(20);
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
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
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Double.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
