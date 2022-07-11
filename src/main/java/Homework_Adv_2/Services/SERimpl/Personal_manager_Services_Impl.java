package Homework_Adv_2.Services.SERimpl;

import Homework_Adv_2.DAO.DAO;
import Homework_Adv_2.Models.Personal_manager;
import Homework_Adv_2.Services.Personal_manager_Services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Personal_manager_Services_Impl implements Personal_manager_Services {

    private DAO<Personal_manager, Integer> dao;

    public Personal_manager_Services_Impl(DAO<Personal_manager, Integer> personal_managerDao) {
        this.dao = personal_managerDao;
    }

    @Override
    public void displayAll() {
        try {
            List<Personal_manager> personal_managers = dao.getAll();
            personal_managers.forEach(System.out::println);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void displayById(int id) {
        try {
            Optional<Personal_manager> optional = dao.getById(id);
            if (optional.isPresent()) {
                System.out.println(optional.get());
            } else {
                System.out.println("Not found record with id " + id);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void create(Personal_manager personal_manager) {
        try {
            dao.insert(personal_manager);
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
