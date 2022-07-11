package Homework_Adv_2.Services.SERimpl;

import Homework_Adv_2.DAO.DAO;
import Homework_Adv_2.Exception.UserNotFoundException;
import Homework_Adv_2.Models.User;
import Homework_Adv_2.Services.User_Services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class User_Services_Impl implements User_Services {
    private DAO<User, Integer> dao;

    public User_Services_Impl(DAO<User, Integer> dao) {
        this.dao = dao;
    }

    @Override
    public void displayAll() {
        try {
            List<User> cars = dao.getAll();
            cars.forEach(System.out::println);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void displayById(int id) throws UserNotFoundException {
        try {
            Optional<User> byId = dao.getById(id);

            if (byId.isPresent()) {
                System.out.println(byId.get());
            } else {
                throw new UserNotFoundException("User with id " + id + " Not Found");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void create(User user) {
        try {
            dao.insert(user);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.delete(id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
