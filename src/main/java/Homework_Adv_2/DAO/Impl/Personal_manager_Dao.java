package Homework_Adv_2.DAO.Impl;

import Homework_Adv_2.DAO.DAO;
import Homework_Adv_2.JDBC.MySqlConnector;
import Homework_Adv_2.Mappers.Personal_manager_mapper;
import Homework_Adv_2.Models.Personal_manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class Personal_manager_Dao implements DAO<Personal_manager, Integer> {
    private final Connection connection;

    public Personal_manager_Dao() {
        this.connection = new MySqlConnector().getConnection();
    }

    @Override
    public List<Personal_manager> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeQuery("SELECT * FROM personal_manager");
        return Personal_manager_mapper.mapToListOfPersonal_manager(statement.getResultSet());
    }

    @Override
    public Optional<Personal_manager> getById(Integer id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeQuery("SELECT * FROM personal_manager WHERE  personal_manager_id='"+id+"'");
        Personal_manager personal_manager = Personal_manager_mapper.mapToListOfPersonal_manager(statement.getResultSet()).get(0);
        return Optional.of(personal_manager);
    }

    @Override
    public void insert(Personal_manager object) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO personal_manager (name) VALUES (?)"
        );
        statement.setString(1, object.name);
        statement.execute();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE * FROM personal_manager WHERE personal_manager_id =?"
        );
        statement.setInt(1, id);
        statement.execute();
    }

    @Override
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
