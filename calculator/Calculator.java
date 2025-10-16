import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField display;
    String operator = "";
    double num1 = 0, num2 = 0, result = 0;

    public Calculator() {
        setTitle("Basic Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        String buttons[] = { "7", "8", "9", "/", "4", "5", "6", "*",
                             "1", "2", "3", "-", "0", "C", "=", "+" };

        for (String text : buttons) {
            JButton b = new JButton(text);
            b.addActionListener(this);
            panel.add(b);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            display.setText(display.getText() + cmd);
        } 
        else if (cmd.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(display.getText());
            operator = cmd;
            display.setText("");
        } 
        else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num2 != 0 ? num1 / num2 : 0; break;
            }
            display.setText(String.valueOf(result));
        } 
        else if (cmd.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
