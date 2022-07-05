package lesson8.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButtonListener implements ActionListener {

    private JTextField inputField;
    public static Integer a;
    public static Integer b;
    public static String o;

    public OperatorButtonListener(JTextField inputField) {
        this.inputField = inputField;
        this.a = null;
        this.o = null;
        this.b = null;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        try {
            Integer.parseInt(inputField.getText().trim());
            if (a == null || o == null) {

                a = Integer.parseInt(inputField.getText().trim());

                inputField.setText(String.valueOf(a + " "));
                o = btn.getText();
            } else {
                b = Integer.parseInt(inputField.getText().trim());
                switch (o) {
                    case "+":
                        a = a + b;
                        inputField.setText(String.valueOf(a + " "));
                        break;
                    case "*":
                        a = a * b;
                        inputField.setText(String.valueOf(a + " "));
                        break;
                    case "/":
                        a = a / b;
                        inputField.setText(String.valueOf(a + " "));
                        break;
                    case "-":
                        a = a - b;
                        inputField.setText(String.valueOf(a + " "));
                        break;
                    default:
                        inputField.setText(String.valueOf(""));

                }
            }
            if (btn.getText() == "=") {
                o = null;
            } else {
                o = btn.getText();
            }
        } catch (NumberFormatException w) {

        }
    }


}
