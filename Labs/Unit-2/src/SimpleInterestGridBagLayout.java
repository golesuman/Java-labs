import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleInterestGridBagLayout implements ActionListener {
    JButton b1;
    JTextField principalField, timeField, rateField, resultField;

    SimpleInterestGridBagLayout() {
        JFrame frame = new JFrame();

        b1 = new JButton("Calculate");
        b1.addActionListener(this);

        JLabel l1 = new JLabel("Principal");
        principalField = new JTextField();
        JLabel l2 = new JLabel("Time");
        timeField = new JTextField();
        JLabel l3 = new JLabel("Rate");
        rateField = new JTextField();
        JLabel l4 = new JLabel("Result");
        resultField = new JTextField();
        resultField.setEditable(false);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Principal Label and Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(l1, gbc);
        gbc.gridx = 1;
        gbc.ipadx = 150; // Set the width of the text field
        frame.add(principalField, gbc);

        // Time Label and Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(l2, gbc);
        gbc.gridx = 1;
        frame.add(timeField, gbc);

        // Rate Label and Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(l3, gbc);
        gbc.gridx = 1;
        frame.add(rateField, gbc);

        // Result Label and Field
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(l4, gbc);
        gbc.gridx = 1;
        frame.add(resultField, gbc);

        // Calculate Button
        gbc.gridx = 1;
        gbc.gridy = 4;
        frame.add(b1, gbc);

        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String principal = principalField.getText();
        String time = timeField.getText();
        String rate = rateField.getText();

        try {
            double principalValue = Double.parseDouble(principal);
            double timeValue = Double.parseDouble(time);
            double rateValue = Double.parseDouble(rate);

            if (actionEvent.getSource() == b1) {
                double result = (principalValue * timeValue * rateValue) / 100;
                String stringResult = String.valueOf(result);
                resultField.setText(stringResult);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values.");
        }
    }

    public static void main(String[] args) {
        new SimpleInterestGridBagLayout();
    }
}
