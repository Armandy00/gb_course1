package lesson8.components;

import javax.swing.*;
import java.awt.*;

public class NumberJbutton extends JButton {
    public NumberJbutton(String text) {
        super(text);
        setFont(new Font("TimesRoman", Font.PLAIN, 25));
        setBackground(new Color(216, 206, 242));
    }
}
