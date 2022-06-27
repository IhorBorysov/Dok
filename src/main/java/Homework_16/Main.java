package Homework_16;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Claass claass=new Claass("Дмитро",19,"Студент",9999999.0);
        Claass claass1=new Claass("Павло",2300000.23);
        Claass claass2=new Claass("Остав",56,10000.97);

        Class<? extends Claass> aClass = claass.getClass();

            //дз
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println("Назва:"+declaredMethod.getName()+"  "+"Тип:"+" "+declaredMethod.getReturnType());
            }

            //дз
            Constructor<?>[] constructors = aClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Конструктор"+" "+constructor+" "+"Кількість елементів у коснтрукторі: "
                        +constructor.getParameterCount());

            }
            //дз

            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println("Назва змінной:"+" "+declaredField.getName()+"     "+"тип:"+declaredField.getType());

            }

            //дз
            Method random_methods = aClass.getDeclaredMethod("random_methods");
            random_methods.invoke(claass2);
            Method full_information = aClass.getDeclaredMethod("full_information",String.class);
            full_information.invoke(claass,"Я студент");

            //дз
            Constructor<? extends Claass> constructor = aClass.getConstructor(String.class,Integer.class,String.class,Double.class);
            Claass two = constructor.newInstance("Саша",69,"Пенсіонер",4500.0);
            System.out.println(two.toString());
            Constructor<? extends Claass> constructor1 = aClass.getConstructor(String.class, Double.class);
            Claass three=constructor1.newInstance("Пенісонер",6900.0);
            System.out.println(three.toString());
    }
}
class Claass{
    private String name;
    private Integer age;
    private String about;
    private double salary;

    Map<String,Integer> map= new HashMap<>();

    public Claass(String name, Integer age, String about, Double salary) {
        this.name = name;
        this.age = age;
        this.about = about;
        this.salary = salary;
    }

    public Claass(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Claass(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    private void private_methods(){
        System.out.println("Приватний метод");
    }
    void full_information(String about_you){
        System.out.println("Імя:"+name+" "+"вік:"+age+" "+"опис:"+about+" "+"зарплата:"+salary);
        System.out.println("Параметир:"+about_you);
    }
    void random_methods (){
        System.out.println("Введіть свій вік:");
        Scanner scanner=new Scanner(System.in);
        int abv=scanner.nextInt();
        if (abv>=18){
            System.out.println("Введіть своє прізвище:");
            Scanner scanner1=new Scanner(System.in);
            String name_time=scanner1.nextLine();
            map.put(name_time,abv);
            System.out.println("Mapa"+map.toString());
        }else {
            System.out.println("Ви неповнолітній!!!!");
            System.exit(0);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Claass)) return false;
        Claass claass = (Claass) o;
        return Double.compare(claass.getSalary(), getSalary()) == 0 && Objects.equals(getName(), claass.getName()) && Objects.equals(getAge(), claass.getAge()) && Objects.equals(getAbout(), claass.getAbout()) && Objects.equals(map, claass.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getAbout(), getSalary(), map);
    }

    @Override
    public String toString() {
        return "One{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", about='" + about + '\'' +
                ", salary=" + salary +
                '}';
    }
}

