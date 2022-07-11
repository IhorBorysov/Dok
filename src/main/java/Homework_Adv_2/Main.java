package Homework_Adv_2;

import Homework_Adv_2.DAO.DAO;
import Homework_Adv_2.DAO.Impl.Personal_manager_Dao;
import Homework_Adv_2.DAO.Impl.User_Dao;
import Homework_Adv_2.Exception.UserNotFoundException;
import Homework_Adv_2.Models.Personal_manager;
import Homework_Adv_2.Models.User;
import Homework_Adv_2.Services.Personal_manager_Services;
import Homework_Adv_2.Services.SERimpl.Personal_manager_Services_Impl;
import Homework_Adv_2.Services.SERimpl.User_Services_Impl;
import Homework_Adv_2.Services.User_Services;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws SQLException {
        DAO<Personal_manager, Integer> personal_manager_dao = new Personal_manager_Dao();
        Personal_manager_Services personal_manager_services = new Personal_manager_Services_Impl(personal_manager_dao);
        System.out.println(ANSI_GREEN+"___________________________________________________________________________________________________________________________________________________"+ANSI_RESET);
        personal_manager_services.displayAll();
        System.out.println(ANSI_GREEN+"___________________________________________________________________________________________________________________________________________________"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"___________________________________________________________________________________________________________________________________________________"+ANSI_RESET);

        personal_manager_services.displayById(7);

        System.out.println(ANSI_BLUE+"___________________________________________________________________________________________________________________________________________________"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"___________________________________________________________________________________________________________________________________________________"+ANSI_RESET);

        DAO<User, Integer> user_dao = new User_Dao();
        User_Services user_services = new User_Services_Impl(user_dao);

        user_services.displayAll();
        System.out.println(ANSI_GREEN+"___________________________________________________________________________________________________________________________________________________"+ANSI_RESET);

        System.out.println(ANSI_BLUE+"___________________________________________________________________________________________________________________________________________________"+ANSI_RESET);

        try {
            user_services.displayById(5);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(ANSI_BLUE+"___________________________________________________________________________________________________________________________________________________"+ANSI_RESET);
        user_services.delete(2);
        user_services.displayAll();

    }
}


