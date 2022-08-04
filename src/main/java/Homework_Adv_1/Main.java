package Homework_Adv_1;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Animal animal=new Animal("Dog");
        Animal animal2=new Animal("Cat");
        Animal animal3=new Animal("Hamster");
        Adress adress=new Adress("Khmelnytskyi");
        List<Animal> animals=new ArrayList<>();
        animals.add(animal);
        animals.add(animal2);
        User user=new User("Ihor",adress,19,animals);
        UserMethod userMethod=new UserMethod("Ihor",adress,19,animals);
        try {
            userMethod.user_18(user);
        } catch (Custom_exception e) {
            throw new RuntimeException(e);
        }

        userMethod.add_adress(user);
        userMethod.remove_adress(user);
        userMethod.add_animals_to_user(user,animal3);
        userMethod.remove_animals_to_user(user,animal2);
        userMethod.edit_fullname(user);
    }
}

