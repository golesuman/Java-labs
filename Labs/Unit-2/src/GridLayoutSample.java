import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutSample implements ActionListener {
    JButton createButton, updateButton, deleteButton;
    JTextField textField1, textField2;

    GridLayoutSample() {
        JFrame frame = new JFrame();
        createButton = new JButton("Clc");
        createButton.addActionListener(this);

        updateButton = new JButton("Update");
        updateButton.addActionListener(this);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);

        textField1 = new JTextField();
        textField2 = new JTextField();

        frame.add(createButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(textField1);
        frame.add(textField2);

        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(3, 3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            System.out.println("Create button clicked");
        } else if (e.getSource() == updateButton) {
            System.out.println("Update button clicked");
        } else if (e.getSource() == deleteButton) {
            System.out.println("Delete button clicked");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GridLayoutSample());
    }
}
