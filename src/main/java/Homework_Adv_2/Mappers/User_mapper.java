package Homework_Adv_2.Mappers;

import Homework_Adv_2.Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User_mapper {
    public static List<User> mapToListOfUser (ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            int age = resultSet.getInt(4);
            String term_of_insurance = resultSet.getString(5);
            int insurannce_premium = resultSet.getInt(6);
            int insurance_payment = resultSet.getInt(7);

            User user = new User(id, name, surname, age, term_of_insurance, insurannce_premium, insurance_payment);
            users.add(user);
        }
        return users;
    }
}
