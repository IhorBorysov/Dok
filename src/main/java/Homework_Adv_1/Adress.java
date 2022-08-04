package Homework_Adv_1;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Adress {
    private String adress;

    public Adress(String adress) {
        this.adress = adress;
    }
}
