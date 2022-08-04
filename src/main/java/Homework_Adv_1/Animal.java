package Homework_Adv_1;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
}


