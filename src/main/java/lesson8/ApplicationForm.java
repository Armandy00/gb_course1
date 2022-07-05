package lesson8;

import lesson8.components.NumberJbutton;
import lesson8.components.OperatorJButton;
import lesson8.listeners.ButtonListener;
import lesson8.listeners.ClearButtonActionListener;
import lesson8.listeners.OperatorButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;

    public ApplicationForm(String title) throws HeadlessException {
        super(title);
        setBounds(600, 500, 250, 370);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        setJMenuBar(createMenu());
        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        //JMenu menuHelp = new JMenu("Help");
        //JMenu menuAbout = new JMenu("About");

        menuBar.add(menuFile);
        //menuBar.add(menuHelp);
        //menuBar.add(menuAbout);
        menuBar.add(new JMenuItem("About"));
        menuBar.add(new JMenuItem("Help"));
        //menuBar.add(new JMenuItem("Exit"));

        menuFile.add(new JMenuItem("Clear"));
        JMenuItem exitItem = menuFile.add(new JMenuItem("Exit"));
        menuBar.add(exitItem);
        //прописываем реакцию на кнопку Экзит - через создание класса
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        //menuFile.add(new JMenuItem("Exit"));


        return menuBar;
    }

    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);
        inputField.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        inputField.setMargin(new Insets(10, 0, 10, 0));
        inputField.setBackground(new Color(255, 255, 255));
        inputField.setText(" ");

        return top;
    }

    private JPanel createCenterPanel() {

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        ActionListener buttonListener = new ButtonListener(inputField);
        ActionListener operatorButtonListener = new OperatorButtonListener(inputField);

        centerPanel.add(createDigitasPanel(buttonListener, operatorButtonListener), BorderLayout.CENTER);

        centerPanel.add(createOperatorsPanel(operatorButtonListener), BorderLayout.WEST);

        return centerPanel;
    }

    private JPanel createOperatorsPanel(ActionListener operatorButtonListener) {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton minus = new OperatorJButton("-");
        minus.addActionListener(operatorButtonListener);
        panel.add(minus);

        JButton plus = new OperatorJButton("+");
        plus.addActionListener(operatorButtonListener);
        panel.add(plus);

        JButton multipy = new OperatorJButton("*");
        multipy.addActionListener(operatorButtonListener);
        panel.add(multipy);

        JButton divide = new OperatorJButton("/");
        divide.addActionListener(operatorButtonListener);
        panel.add(divide);

        return panel;
    }

    private JPanel createDigitasPanel(ActionListener buttonListener, ActionListener operatorButtonListener) {
        JPanel digitsPanel = new JPanel();
        digitsPanel.setLayout(new GridLayout(4, 3));
        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i + 1);
            JButton btn = (JButton) digitsPanel.add(new NumberJbutton(buttonTitle));
            btn.addActionListener(buttonListener);
        }

        JButton calc = new OperatorJButton("=");
        calc.addActionListener(operatorButtonListener);

        digitsPanel.add(calc);

        JButton clear = new OperatorJButton("C");
        digitsPanel.add(clear);
        clear.addActionListener(new ClearButtonActionListener(inputField));

        return digitsPanel;
    }



}
