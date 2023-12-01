import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StudentRecordForm extends JFrame {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField ageField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JComboBox<String> facultyComboBox;
    private JComboBox<String> semesterComboBox;
    private JTextArea remarksTextArea;

    public StudentRecordForm() {
        // Set up the frame
        setTitle("Student Record Form");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);

        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField(5);

        JLabel genderLabel = new JLabel("Gender:");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JLabel facultyLabel = new JLabel("Faculty:");
        String[] faculties = {"Science", "Management", "Humanities"};
        facultyComboBox = new JComboBox<>(faculties);

        JLabel semesterLabel = new JLabel("Semester:");
        String[] semesters = {"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth"};
        semesterComboBox = new JComboBox<>(semesters);

        JLabel remarksLabel = new JLabel("Remarks:");
        remarksTextArea = new JTextArea(5, 20);
        JScrollPane remarksScrollPane = new JScrollPane(remarksTextArea);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });

        // Set up layout manager
        setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(firstNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lastNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(ageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(genderLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(maleRadioButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        add(femaleRadioButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(facultyLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(facultyComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(semesterLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(semesterComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(remarksLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(remarksScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(saveButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        add(resetButton, gbc);
    }

    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()))) {
                writer.write("First Name: " + firstNameField.getText() + "\n");
                writer.write("Last Name: " + lastNameField.getText() + "\n");
                writer.write("Age: " + ageField.getText() + "\n");
                writer.write("Gender: " + (maleRadioButton.isSelected() ? "Male" : "Female") + "\n");
                writer.write("Faculty: " + facultyComboBox.getSelectedItem() + "\n");
                writer.write("Semester: " + semesterComboBox.getSelectedItem() + "\n");
                writer.write("Remarks: " + remarksTextArea.getText());
                JOptionPane.showMessageDialog(this, "Record saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving the file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void resetForm() {
        firstNameField.setText("");
        lastNameField.setText("");
        ageField.setText("");
        maleRadioButton.setSelected(false);
        femaleRadioButton.setSelected(false);
        facultyComboBox.setSelectedIndex(0);
        semesterComboBox.setSelectedIndex(0);
        remarksTextArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentRecordForm().setVisible(true);
            }
        });
    }
}
