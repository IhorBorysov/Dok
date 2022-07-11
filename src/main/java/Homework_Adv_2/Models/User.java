package Homework_Adv_2.Models;

import lombok.Data;

@Data
public class User {
    public int user_id;
    public String name;
    public String surname;
    public int age;
    public String term_of_insurance;
    public int insurannce_premium;
    public int insurance_payment;

    public User(int user_id, String name, String surname, int age, String term_of_insurance, int insurannce_premium, int insurance_payment) {
        this.user_id = user_id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.term_of_insurance = term_of_insurance;
        this.insurannce_premium = insurannce_premium;
        this.insurance_payment = insurance_payment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", term_of_insurance='" + term_of_insurance + '\'' +
                ", insurannce_premium=" + insurannce_premium +
                ", insurance_payment=" + insurance_payment +
                '}';
    }
}
