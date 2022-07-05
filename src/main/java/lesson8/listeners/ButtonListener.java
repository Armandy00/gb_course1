package lesson8.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JTextField inputField;

    public ButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (inputField.getText().length() > 0 && Character.isDigit(inputField.getText().charAt(inputField.getText().length() - 1))) {
            inputField.setText(inputField.getText() + btn.getText());
        } else {
            inputField.setText(btn.getText());
        }

    }
}