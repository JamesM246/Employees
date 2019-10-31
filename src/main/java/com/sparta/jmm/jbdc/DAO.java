package com.sparta.jmm.jbdc;

import com.sparta.jmm.manager.Employee;

import java.sql.*;

public class DAO {
    private static Connection connection;
    private static PreparedStatement statement;
    private static final String INSERT_STATEMENT = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String URL = "jdbc:mysql://localhost/employees?user=root&password=Tess246bear731";

    public static void openConnection() throws SQLException {
        connection = DriverManager.getConnection(URL);
    }
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    public static void runQuery(Employee employee){
        try{
            statement = connection.prepareStatement(INSERT_STATEMENT);
            statement.setInt(1, employee.getId());
            statement.setString(2,employee.getPrefix());
            statement.setString(3,employee.getFirstName());
            statement.setString(4,Character.toString(employee.getMiddleInitial()));
            statement.setString(5,employee.getLastName());
            statement.setString(6,Character.toString(employee.getGender()));
            statement.setString(7,employee.getEmail());
            statement.setDate(8,Date.valueOf(employee.getDateBirth()));
            statement.setDate(9,Date.valueOf(employee.getDateJoin()));
            statement.setInt(10,employee.getSalary());

            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
