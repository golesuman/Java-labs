package Table;

import java.sql.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


class MysqlCon {
    private DefaultTableModel model;
    public ResultSet getResultSet() {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "my-password";
        

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM Employee.EmployeeDetails";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                return resultSet;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void closeConnection(){
        
    }

    public static void main(String args[]) {

    }
}