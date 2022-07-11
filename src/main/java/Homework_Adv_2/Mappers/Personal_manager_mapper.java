package Homework_Adv_2.Mappers;

import Homework_Adv_2.Models.Personal_manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

public class Personal_manager_mapper {
    public static List<Personal_manager> mapToListOfPersonal_manager(ResultSet resultSet) throws SQLException {
        List<Personal_manager> personal_managers = new ArrayList<>();
        while (resultSet.next()){
            Personal_manager personal_manager = new Personal_manager( resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4));

            personal_managers.add(personal_manager);
        }
        return personal_managers;
    }
}
