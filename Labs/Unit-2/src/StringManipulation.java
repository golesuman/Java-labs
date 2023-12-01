import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StringManipulation extends JFrame {

    private JTextField textField;
    private JLabel labelMessage;

    public StringManipulation() {
        // Set up the frame
        setTitle("String Manipulation");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        labelMessage = new JLabel("Input any string");
        textField = new JTextField(20);

        JButton checkPalindromeButton = new JButton("Check Palindrome");
        checkPalindromeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPalindrome();
            }
        });

        JButton reverseButton = new JButton("Reverse");
        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reverseString();
            }
        });

        JButton findVowelsButton = new JButton("Find Vowels");
        findVowelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findVowels();
            }
        });

        // Set up the layout
        setLayout(new java.awt.FlowLayout());

        // Add components to the frame
        add(labelMessage);
        add(textField);
        add(checkPalindromeButton);
        add(reverseButton);
        add(findVowelsButton);
    }

    private void checkPalindrome() {
        String input = textField.getText();
        String reversed = new StringBuilder(input).reverse().toString();

        if (input.equalsIgnoreCase(reversed)) {
            labelMessage.setText("Palindrome: Yes");
        } else {
            labelMessage.setText("Palindrome: No");
        }
    }

    private void reverseString() {
        String input = textField.getText();
        String reversed = new StringBuilder(input).reverse().toString();
        labelMessage.setText("Reversed String: " + reversed);
    }

    private void findVowels() {
        String input = textField.getText();
        String vowels = input.replaceAll("[^aeiouAEIOU]", "");
        labelMessage.setText("Vowels: " + vowels);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StringManipulation().setVisible(true);
            }
        });
    }
}
