package Homework_Adv_2.Models;

import lombok.Data;

@Data
public class Personal_manager {
    public int personal_manager_id;
    public String name;
    public String surname;
    public int age;

    public Personal_manager(int personal_manager_id, String name, String surname, int age) {
        this.personal_manager_id = personal_manager_id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Personal_manager{" +
                "id=" + personal_manager_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
