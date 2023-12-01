import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTwoNumbers {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JButton b = new JButton("click");
        b.setBounds(50, 300, 30, 30);
        JTextField textField = new JTextField("A");
        textField.setBounds(50, 100, 200, 30);

        JTextField textField2 = new JTextField("B");
        textField2.setBounds(50, 150, 200, 30);

        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(50, 200, 200, 30);

        f.add(b);
        f.add(textField);
        f.add(textField2);
        f.add(resultLabel);
        f.setLayout(null);
        f.setSize(300, 300); // Increased the frame size
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Read data from the text fields
                    String inputTextA = textField.getText();
                    String inputTextB = textField2.getText();

                    // Convert the input strings to numbers
                    double numberA = Double.parseDouble(inputTextA);
                    double numberB = Double.parseDouble(inputTextB);

                    // Calculate the result
                    double result = numberA + numberB;

                    // Display the result
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter numbers.");
                }
            }
        });
    }
}
