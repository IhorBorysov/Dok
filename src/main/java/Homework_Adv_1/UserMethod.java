package Homework_Adv_1;
import java.util.List;

public class UserMethod  extends  User{
    public UserMethod(String fullName, Adress adress, int age, List<Animal> list) {
        super(fullName, adress, age, list);
    }



    public void user_18(User user) throws Custom_exception {
        if (user.getAge()>=18){
            System.out.println("Ви повнолітній!");
        }else{
            throw new Custom_exception();
        }
    }

    public void add_adress(User user){
//        System.out.println("Введіть новий адрес:");
//        Scanner scanner=new Scanner(System.in);
//        String newarress=scanner.nextLine();
        String newarress="Київ";
        user.adress.setAdress(newarress);
        System.out.println(user);


    }
    public void remove_adress(User user){
        user.adress.setAdress(null);
        System.out.println(user);

    }

    public void add_animals_to_user(User user,Animal animal){
        System.out.println(user);
        user.list.add(animal);
        System.out.println(user);

    }

    public void remove_animals_to_user(User user,Animal animal){
        System.out.println(user);
        user.list.remove(animal);
        System.out.println(user);

    }

    public void edit_fullname(User user){
//        System.out.println("Введіть оновлену назву:");
//        Scanner scanner=new Scanner(System.in);
//        String name=scanner.nextLine();
        String name="Володимир";
        user.setFullName(name);
        System.out.println(user);
    }

    @Override
    public String toString() {
        return "UserMethod{" +
                "adress=" + adress +
                ", list=" + list +
                '}';
    }
}
