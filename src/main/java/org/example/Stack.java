package org.example;

public class Stack{
    private double [] elements;
    private int top;

    public Stack(int capacity) {    
        elements = new double[capacity];
        top = -1;
    }

    public double top() {
        if (top == -1) {
            throw new RuntimeException("Pila vacía");
        }
        return elements[top];  // Devuelve el valor sin eliminarlo
    }

    public void push(double value) {
        if (top == elements.length - 1) {
            throw new StackOverflowError("El stack está lleno");
        }
        elements[++top] = value;
    }

    public double pop() {
        if (top == -1) {
            throw new RuntimeException("Pila vacía");
        }
        return elements[top--];  // Devuelve y elimina el valor
    }

    public void makeNull() {
        top = -1;  // Reinicia el stack
    }
    public boolean isEmpty() {
        return top == -1;
    }
}