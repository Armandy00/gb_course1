package lesson8.components;

import javax.swing.*;
import java.awt.*;

public class OperatorJButton extends JButton {
    public OperatorJButton(String text) {
        super(text);
        setFont(new Font("TimesRoman", Font.BOLD, 30));
        setBackground(new Color(153, 2, 182));
    }
}
