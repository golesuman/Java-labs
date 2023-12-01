import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplyTwoNumber extends JFrame {

    private JTextField textFieldNum1;
    private JTextField textFieldNum2;
    private JTextField textFieldResult;

    public MultiplyTwoNumber() {
        // Set up the frame
        setTitle("Multiply Two Numbers");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel labelNum1 = new JLabel("Enter Number 1:");
        textFieldNum1 = new JTextField(10);

        JLabel labelNum2 = new JLabel("Enter Number 2:");
        textFieldNum2 = new JTextField(10);

        JButton multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplyNumbers();
            }
        });

        JLabel labelResult = new JLabel("Result:");
        textFieldResult = new JTextField(10);
        textFieldResult.setEditable(false);

        // Set up the layout
        setLayout(new java.awt.GridLayout(4, 2, 10, 10));

        // Add components to the frame
        add(labelNum1);
        add(textFieldNum1);
        add(labelNum2);
        add(textFieldNum2);
        add(multiplyButton);
        add(new JLabel()); // Empty cell for spacing
        add(labelResult);
        add(textFieldResult);
    }

    private void multiplyNumbers() {
        try {
            double num1 = Double.parseDouble(textFieldNum1.getText());
            double num2 = Double.parseDouble(textFieldNum2.getText());
            double result = num1 * num2;
            textFieldResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            textFieldResult.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MultiplyTwoNumber().setVisible(true);
            }
        });
    }
}
