package StudentCRUD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CrudApp2 extends JFrame {
    private JTextField idField, nameField, ageField;
    private JButton addButton, updateButton, deleteButton, fetchButton, showAllButton;
    private Connection connection;
    private DefaultTableModel tableModel;
    private JTable table;

    public CrudApp2() {
        initializeUI();
        initDatabase();
    }

    private void initializeUI() {
        setTitle("CRUD Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        idField = new JTextField();
        nameField = new JTextField();
        ageField = new JTextField();

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        fetchButton = new JButton("Fetch");
        showAllButton = new JButton("Show All");

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

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllData();
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
        panel.add(showAllButton);

        add(panel);
        setVisible(true);
    }

    private void initDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Person";
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
        // ... (same as before)
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
        // ... (same as before)
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
        // ... (same as before)
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
        // ... (same as before)
    }

    private void showAllData() {
        JFrame tableFrame = new JFrame("All Persons");
        tableFrame.setSize(400, 300);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        tableFrame.add(scrollPane);

        fetchAllData();

        tableFrame.setVisible(true);
    }

    private void fetchAllData() {
        try {
            String query = "SELECT * FROM person";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    tableModel.addRow(new Object[]{id, name, age});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CrudApp2();
            }
        });
    }
}
