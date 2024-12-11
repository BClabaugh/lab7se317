package org.example;
import java.util.Observable;

public class CalculatorModel extends Observable {
    private double result = 0;
    private double memory = 0;

    public void calculate(String operation, double operand1, double operand2) throws IllegalArgumentException {
        switch (operation) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                result = operand1 / operand2;
                break;
            case "√":
                if (operand1 < 0) {
                    throw new IllegalArgumentException("Cannot calculate square root of a negative number");
                }
                result = Math.sqrt(operand1);
                break;
            case "^2":
                result = Math.pow(operand1, 2);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
        setChanged();
        notifyObservers(result);
    }

    public void addToMemory(double value) {
        memory += value;
    }

    public void subtractFromMemory(double value) {
        memory -= value;
    }

    public double recallMemory() {
        return memory;
    }

    public void clearMemory() {
        memory = 0;
    }

    public double getResult() {
        return result;
    }
}
