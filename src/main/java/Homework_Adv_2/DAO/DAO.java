package Homework_Adv_2.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T, K> {
    List<T> getAll() throws SQLException;
    Optional<T> getById(K id) throws SQLException;
    void insert(T object) throws SQLException;
    void delete(K id) throws SQLException;
    void closeConnection() throws SQLException;
}
