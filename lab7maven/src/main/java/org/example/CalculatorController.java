package org.example;
import javax.swing.*;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    private String currentOperation = "";
    private double firstOperand = 0;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        // Attach Listeners
        for (JButton button : view.getDigitButtons()) {
            button.addActionListener(e -> view.getDisplay().setText(view.getDisplay().getText() + button.getText()));
        }
        view.getDecimalButton().addActionListener(e -> view.getDisplay().setText(view.getDisplay().getText() + view.getDecimalButton().getText()));
        view.getAddButton().addActionListener(e -> processOperation("+"));
        view.getSubtractButton().addActionListener(e -> processOperation("-"));
        view.getMultiplyButton().addActionListener(e -> processOperation("*"));
        view.getDivideButton().addActionListener(e -> processOperation("/"));
        view.getSquareButton().addActionListener(e -> processOperation("^2"));
        view.getSqrtButton().addActionListener(e -> processOperation("√"));
        view.getEqualButton().addActionListener(e -> execute());
        view.getClearButton().addActionListener(e -> clear());
        view.getMemAddButton().addActionListener(e -> model.addToMemory(model.getResult()));
        view.getMemSubButton().addActionListener(e -> model.subtractFromMemory(model.getResult()));
        view.getMemRecallButton().addActionListener(e -> view.getDisplay().setText(String.valueOf(model.recallMemory())));
        view.getMemClearButton().addActionListener(e -> model.clearMemory());
    }

    private void processOperation(String operation) {
        try {
            if (!view.getDisplay().getText().isEmpty()) {
                firstOperand = Double.parseDouble(view.getDisplay().getText());
                currentOperation = operation;
                view.getDisplay().setText(""); // Clear display for the next input
                view.getOperatorLabel().setText(operation); // Assume the view has a label for showing the operator
            }
        } catch (NumberFormatException e) {
            view.getDisplay().setText("Error");
        }
    }


    private void execute() {
        try {
            double secondOperand = 0;
            if (!currentOperation.equals("√") && !currentOperation.equals("^2")) {
                secondOperand = Double.parseDouble(view.getDisplay().getText());
            }

            switch (currentOperation) {
                case "+":
                case "-":
                case "*":
                case "/":
                    model.calculate(currentOperation, firstOperand, secondOperand);
                    break;
                case "^2":
                case "√":
                    model.calculate(currentOperation, firstOperand, 0);
                    break;
                default:
                    throw new IllegalArgumentException("No operation selected");
            }

            view.getOperatorLabel().setText(""); // Clear the operator display after execution
            currentOperation = ""; // Reset current operation after execution
        } catch (IllegalArgumentException e) {
            view.getDisplay().setText("Error");
        }
    }

    private void clear() {
        view.getDisplay().setText("");
        currentOperation = "";
        firstOperand = 0;
    }
}