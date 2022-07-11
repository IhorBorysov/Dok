package Homework_Adv_2.Services;

import Homework_Adv_2.Models.Personal_manager;

public interface Personal_manager_Services {
    void displayAll();
    void displayById(int id);
    void create(Personal_manager personal_manager);
    void delete(int id);
}
