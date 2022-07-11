package Homework_Adv_2.Services;

import Homework_Adv_2.Exception.UserNotFoundException;
import Homework_Adv_2.Models.User;

public interface User_Services {
    void displayAll();
    void displayById(int id) throws UserNotFoundException;
    void create(User user);
    void delete(int id);
}
