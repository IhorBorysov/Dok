package Homework_Adv_2.DAO.Impl;

import Homework_Adv_2.DAO.DAO;
import Homework_Adv_2.JDBC.MySqlConnector;
import Homework_Adv_2.Mappers.User_mapper;
import Homework_Adv_2.Models.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class User_Dao implements DAO<User, Integer> {

    Connection connection;

    public User_Dao() {
        this.connection = new MySqlConnector().getConnection();
    }

    @Override
    public List<User> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        return User_mapper.mapToListOfUser(resultSet);
    }

    @Override
    public Optional<User> getById(Integer id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE user_id= '" + id + "' LIMIT 1");
        List<User> users = User_mapper.mapToListOfUser(resultSet);
        User user = null;
        if (users.size() != 0) {
            user  = users.get(0);
        }

        return Optional.ofNullable(user);
    }


    @Override
    public void insert(User object) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO user (name) VALUES (?)"
        );
        statement.setString(1, object.name);
        statement.execute();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM user WHERE user_id =?"
        );
        statement.setInt(1, id);
        statement.execute();
    }

    @Override
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
