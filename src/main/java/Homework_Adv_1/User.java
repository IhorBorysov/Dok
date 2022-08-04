package Homework_Adv_1;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class User {
    private String fullName;
    Adress adress;
    private int age;
    List<Animal> list=new ArrayList<Animal>();

    public User(String fullName, Adress adress, int age, List<Animal> list) {
        this.fullName = fullName;
        this.adress = adress;
        this.age = age;
        this.list = list;
    }
}
