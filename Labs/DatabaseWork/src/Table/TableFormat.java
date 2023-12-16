package Table;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class TableFormat extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public TableFormat() {
        setTitle("JTable Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        model = new DefaultTableModel();
        table = new JTable(model);
        MysqlCon dbCon = new MysqlCon();

        ResultSet resultSet = dbCon.getResultSet();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                model.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // fetchDataFromDatabase();

        setVisible(true);
    }

    // private void fetchDataFromDatabase() {
    // String url = "jdbc:mysql://localhost:3306";
    // String user = "root";
    // String password = "my-password";

    // try (Connection connection = DriverManager.getConnection(url, user,
    // password)) {
    // String sql = "SELECT * FROM Employee.EmployeeDetails";
    // try (PreparedStatement statement = connection.prepareStatement(sql);
    // ResultSet resultSet = statement.executeQuery()) {

    // }
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    // }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TableFormat());
    }
}
