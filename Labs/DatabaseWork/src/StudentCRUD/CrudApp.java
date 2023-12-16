package StudentCRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CrudApp extends JFrame {
    private JTextField idField, nameField, ageField;
    private JButton addButton, updateButton, deleteButton, fetchButton;
    private Connection connection;

    public CrudApp() {
        initializeUI();
        initDatabase();
    }

    private void initializeUI() {
        setTitle("CRUD Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        idField = new JTextField();
        nameField = new JTextField();
        ageField = new JTextField();

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        fetchButton = new JButton("Fetch");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPerson();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePerson();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePerson();
            }
        });

        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchPerson();
            }
        });

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(fetchButton);

        add(panel);
        setVisible(true);
    }

    private void initDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://0.0.0.0:3306/Person";
            String username = "root";
            String password = "my-password";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void addPerson() {
        try {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());

            String query = "INSERT INTO person (name, age) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);
                statement.setInt(2, age);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Person added successfully");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding person");
        }
    }

    private void updatePerson() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());

            String query = "UPDATE person SET name=?, age=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);
                statement.setInt(2, age);
                statement.setInt(3, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Person updated successfully");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating person");
        }
    }

    private void deletePerson() {
        try {
            int id = Integer.parseInt(idField.getText());

            String query = "DELETE FROM person WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Person deleted successfully");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting person");
        }
    }

    private void fetchPerson() {
        try {
            int id = Integer.parseInt(idField.getText());

            String query = "SELECT * FROM person WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        nameField.setText(name);
                        ageField.setText(String.valueOf(age));
                    } else {
                        JOptionPane.showMessageDialog(this, "Person not found");
                    }
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching person");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CrudApp();
            }
        });
    }
}

