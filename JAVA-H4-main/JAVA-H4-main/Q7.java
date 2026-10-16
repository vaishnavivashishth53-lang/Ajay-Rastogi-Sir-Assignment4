import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q7 extends JFrame implements ActionListener {
    private JTextField displayField;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator = '\0';

    public Q7() {
        setTitle("Calculator");
        setSize(330, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        // Color Palette
        Color bgDark = new Color(33, 37, 43);        // Dark Charcoal frame
        Color panelBg = new Color(40, 44, 52);       // Panel background
        Color btnNumBg = new Color(240, 240, 240);   // Off-white for numbers
        Color btnOpBg = new Color(220, 230, 242);    // Light soft blue for operators
        Color clearBg = new Color(255, 102, 102);    // Soft Red for Clear All
        Color backspaceBg = new Color(255, 179, 102); // Soft Orange for Backspace
        Color equalsBg = new Color(255, 127, 80);    // Coral orange for Equals

        // Outer container padding
        JPanel contentPane = new JPanel(new BorderLayout(8, 8));
        contentPane.setBackground(bgDark);
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        // Display Field
        displayField = new JTextField();
        displayField.setFont(new Font("Consolas", Font.BOLD, 22));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setBackground(new Color(20, 24, 30));
        displayField.setForeground(new Color(0, 255, 204)); // Bright Cyan text
        displayField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 64, 72), 1),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        add(displayField, BorderLayout.NORTH);

        // Buttons Panel (5 rows x 4 columns - Fully Aligned Grid)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 6, 6));
        buttonPanel.setBackground(panelBg);

        String[] buttons = {
            "C",  "←", "%", "/",  // Row 1: Clear All and Backspace on the same line
            "7",  "8", "9", "*",  // Row 2
            "4",  "5", "6", "-",  // Row 3
            "1",  "2", "3", "+",  // Row 4
            "00", "0", ".", "="   // Row 5: Equals aligned smoothly into the grid
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.setFocusPainted(false);
            btn.addActionListener(this);

            if (text.equals("C")) {
                btn.setBackground(clearBg);
                btn.setForeground(Color.WHITE);
            } else if (text.equals("←")) {
                btn.setBackground(backspaceBg);
                btn.setForeground(Color.WHITE);
            } else if (text.equals("=")) {
                btn.setBackground(equalsBg);
                btn.setForeground(Color.WHITE);
            } else if (text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/") || text.equals("%")) {
                btn.setBackground(btnOpBg);
                btn.setForeground(new Color(20, 40, 80));
            } else {
                btn.setBackground(btnNumBg);
                btn.setForeground(Color.BLACK);
            }

            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".") || command.equals("00")) {
            displayField.setText(displayField.getText() + command);
        } else if (command.equals("C")) {
            displayField.setText("");
            num1 = num2 = result = 0;
            operator = '\0';
        } else if (command.equals("←")) {
            String currentText = displayField.getText();
            if (!currentText.isEmpty()) {
                char removedChar = currentText.charAt(currentText.length() - 1);
                if (removedChar == '+' || removedChar == '-' || removedChar == '*' || removedChar == '/' || removedChar == '%') {
                    operator = '\0';
                }
                displayField.setText(currentText.substring(0, currentText.length() - 1));
            }
        } else if (command.equals("=")) {
            if (operator != '\0' && !displayField.getText().isEmpty()) {
                String currentText = displayField.getText();
                int opIndex = currentText.lastIndexOf(operator);
                if (opIndex != -1 && opIndex < currentText.length() - 1) {
                    String secondNumStr = currentText.substring(opIndex + 1);
                    if (!secondNumStr.isEmpty()) {
                        num2 = Double.parseDouble(secondNumStr);
                        switch (operator) {
                            case '+': result = num1 + num2; break;
                            case '-': result = num1 - num2; break;
                            case '*': result = num1 * num2; break;
                            case '/': 
                                if (num2 != 0) {
                                    result = num1 / num2;
                                } else {
                                    displayField.setText("Error: Div by 0");
                                    return;
                                }
                                break;
                            case '%': result = num1 % num2; break;
                        }
                        // Displays evaluated decimal output (e.g. 52.0*4.0=208.0)
                        displayField.setText(num1 + "" + operator + "" + num2 + "=" + result);
                        operator = '\0';
                    }
                }
            }
        } else { // Operator (+, -, *, /, %)
            if (!displayField.getText().isEmpty() && operator == '\0') {
                num1 = Double.parseDouble(displayField.getText());
                operator = command.charAt(0);
                displayField.setText(displayField.getText() + operator);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Q7());
    }
}