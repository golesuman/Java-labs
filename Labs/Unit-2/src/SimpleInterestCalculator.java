import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleInterestCalculator extends JFrame {

    private JTextField textFieldPrincipal;
    private JTextField textFieldRate;
    private JTextField textFieldTime;
    private JTextField textFieldResult;

    public SimpleInterestCalculator() {
        // Set up the frame
        setTitle("Simple Interest Calculator");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel labelPrincipal = new JLabel("Principal Amount:");
        textFieldPrincipal = new JTextField(10);

        JLabel labelRate = new JLabel("Interest Rate (%):");
        textFieldRate = new JTextField(10);

        JLabel labelTime = new JLabel("Time (Years):");
        textFieldTime = new JTextField(10);

        JButton calculateButton = new JButton("Calculate Interest");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSimpleInterest();
            }
        });

        JLabel labelResult = new JLabel("Simple Interest:");
        textFieldResult = new JTextField(10);
        textFieldResult.setEditable(false);

        // Set up the layout
        setLayout(new java.awt.GridLayout(5, 2, 10, 10));

        // Add components to the frame
        add(labelPrincipal);
        add(textFieldPrincipal);
        add(labelRate);
        add(textFieldRate);
        add(labelTime);
        add(textFieldTime);
        add(calculateButton);
        add(new JLabel()); // Empty cell for spacing
        add(labelResult);
        add(textFieldResult);
    }

    private void calculateSimpleInterest() {
        try {
            double principal = Double.parseDouble(textFieldPrincipal.getText());
            double rate = Double.parseDouble(textFieldRate.getText());
            double time = Double.parseDouble(textFieldTime.getText());

            double simpleInterest = (principal * rate * time) / 100;
            textFieldResult.setText(String.valueOf(simpleInterest));
        } catch (NumberFormatException ex) {
            textFieldResult.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleInterestCalculator().setVisible(true);
            }
        });
    }
}
