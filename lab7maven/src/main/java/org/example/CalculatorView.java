package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class CalculatorView extends JFrame implements Observer {
    private JTextField display = new JTextField();
    private JButton[] digitButtons = new JButton[10];
    private JButton decimalButton = new JButton(".");
    private JButton addButton = new JButton("+");
    private JButton subtractButton = new JButton("-");
    private JButton multiplyButton = new JButton("*");
    private JButton divideButton = new JButton("/");
    private JButton squareButton = new JButton("^2");
    private JButton sqrtButton = new JButton("√");
    private JButton equalButton = new JButton("=");
    private JButton clearButton = new JButton("C");
    private JButton deleteButton = new JButton("Del");
    private JButton memAddButton = new JButton("M+");
    private JButton memSubButton = new JButton("M-");
    private JButton memRecallButton = new JButton("MR");
    private JButton memClearButton = new JButton("MC");

    public CalculatorView() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Layout
        setLayout(new BorderLayout());
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel(new GridLayout(6, 4));

        memAddButton.setName("M+");
        memSubButton.setName("M-");
        memRecallButton.setName("MR");
        memClearButton.setName("MC");

        // Set names for the function buttons
        squareButton.setName("^2");
        sqrtButton.setName("√");
        divideButton.setName("/");
        multiplyButton.setName("*");
        subtractButton.setName("-");
        addButton.setName("+");
        equalButton.setName("=");
        clearButton.setName("C");
        deleteButton.setName("Del");
        decimalButton.setName(".");
        buttonPanel.add(memAddButton);
        buttonPanel.add(memSubButton);
        buttonPanel.add(memRecallButton);
        buttonPanel.add(memClearButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(sqrtButton);
        for (int i = 9; i > -1; i--) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].setName("digit" + i);
        }
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(digitButtons[9]);
        buttonPanel.add(digitButtons[8]);
        buttonPanel.add(digitButtons[7]);
        buttonPanel.add(divideButton);
        buttonPanel.add(digitButtons[6]);
        buttonPanel.add(digitButtons[5]);
        buttonPanel.add(digitButtons[4]);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(digitButtons[3]);
        buttonPanel.add(digitButtons[2]);
        buttonPanel.add(digitButtons[1]);
        buttonPanel.add(subtractButton);
        buttonPanel.add(decimalButton);
        buttonPanel.add(digitButtons[0]);
        buttonPanel.add(equalButton);
        buttonPanel.add(addButton);


        add(buttonPanel, BorderLayout.CENTER);
    }

    private JLabel operatorLabel = new JLabel();

    public JLabel getOperatorLabel() {
        return operatorLabel;
    }


    public JTextField getDisplay() {
        return display;
    }

    public JButton[] getDigitButtons() {
        return digitButtons;
    }

    public JButton getDecimalButton(){return decimalButton;}

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getSquareButton() {
        return squareButton;
    }

    public JButton getSqrtButton() {
        return sqrtButton;
    }

    public JButton getEqualButton() {
        return equalButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getMemAddButton() {
        return memAddButton;
    }

    public JButton getMemSubButton() {
        return memSubButton;
    }

    public JButton getMemRecallButton() {
        return memRecallButton;
    }

    public JButton getMemClearButton() {
        return memClearButton;
    }

    @Override
    public void update(Observable o, Object arg) {
        display.setText(String.valueOf(arg));
    }
}

