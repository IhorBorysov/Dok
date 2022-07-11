package Homework_Adv_2;

import java.sql.*;

public class ConnectionService {
    private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/insurance_company?serverTimezone=UTC";

    private static String USER_NAME = "root";
    private static String PASSWORD = "Qwerzxc_777";

    public static ResultSet executeQuery(String query, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public static Connection getConnection(){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

}
