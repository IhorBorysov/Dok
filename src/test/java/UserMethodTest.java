import Homework_Adv_1.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class UserMethodTest {
    private User user;
    private User user1;
    private UserMethod userMethod;
    private Adress adress;

    private List<Animal> animals=new ArrayList<>();


    @BeforeEach
    public void init(){
        Animal animal1=new Animal("Horse");
        Animal animal2=new Animal("Boar");
        Animal animal3=new Animal("Wolf");
        animals.add(animal1);
        animals.add(animal2);
        adress=new Adress("Lviv");

        userMethod=new UserMethod("Ihor",adress,19,animals);
        user=new User("Ihor",adress,19,animals);
        user1=new User("Andriy",adress,10,animals);
    }


    @DisplayName("check age")
    @Test
    public void user_18_test() throws Custom_exception {
        userMethod.user_18(user);
        Assertions.assertThrows(Custom_exception.class,()->userMethod.user_18(user1));

    }



    @Test
    @DisplayName("Remove adres test")
    public void remove_adress_test(){
        userMethod.remove_adress(user);
        userMethod.remove_adress(user1);

    }



    @Test
    @DisplayName("ADD ADRESS TEST")
    public void add_adress_test(){
        userMethod.add_adress(user);
    }



    @ParameterizedTest(name = "obj={0}")
    @DisplayName("Add Animals Test")
    @CsvSource({
            "Слон",
            "Тірекс"
    })
    public void add_animals_test(Animal animal){
        userMethod.add_animals_to_user(user1,animal);

    }



    @ParameterizedTest(name = "obj={0}")
    @CsvSource({
            "Ведмідь"
    })
    @DisplayName("Remove animals")
    public void remove_animals_test(Animal animal){
        userMethod.remove_animals_to_user(user,animal);

    }



    @Test
    @DisplayName("Edit fullname")
    public void edit_fullname_test(){
        userMethod.edit_fullname(user1);
    }
}
