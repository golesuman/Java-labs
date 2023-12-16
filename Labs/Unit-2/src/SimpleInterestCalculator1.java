import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleInterestCalculator1 extends JFrame implements ActionListener {
    // GUI components
    private JTextField principalField, rateField, timeField, resultField;
    private JButton calculateButton;

    public SimpleInterestCalculator1() {
        // Set up the JFrame
        setTitle("Simple Interest Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create GridLayout with 4 rows and 2 columns
        setLayout(new GridLayout(4, 2, 10, 10));

        // Create and add components
        add(new JLabel("Principal Amount:"));
        principalField = new JTextField();
        add(principalField);

        add(new JLabel("Rate of Interest (%):"));
        rateField = new JTextField();
        add(rateField);

        add(new JLabel("Time (years):"));
        timeField = new JTextField();
        add(timeField);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton);

        add(new JLabel("Simple Interest:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button click event
        if (e.getSource() == calculateButton) {
            calculateSimpleInterest();
        }
    }

    private void calculateSimpleInterest() {
        try {
            // Get values from text fields
            double principal = Double.parseDouble(principalField.getText());
            double rate = Double.parseDouble(rateField.getText());
            double time = Double.parseDouble(timeField.getText());

            // Calculate simple interest
            double simpleInterest = (principal * rate * time) / 100;

            // Display result in the resultField
            resultField.setText(String.format("%.2f", simpleInterest));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numerical values.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleInterestCalculator1 calculator = new SimpleInterestCalculator1();
            calculator.setVisible(true);
        });
    }
}
