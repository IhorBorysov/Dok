package Homework_14;


import java.util.*;

public class Main {
    public static final String ANSI_GREEN2 = "\u001B[42m";
    public static final String ANSI_BLUE2 = "\u001B[44m";
    public static final String ANSI_YELLOW = "\u001B[43m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static void main(String[] args) {
        Set<User> user = new HashSet<>();

        User a = new User("Ihor",19);
        User b = new User("Andriy",22);
        User c = new User("Nastya",24);
        User d = new User("Alina",20);
        User e = new User("Alex",13);
        User f = new User("Dima",35);
        User j = new User("Sergiy",17);

        user.add(a);
        user.add(b);
        user.add(c);
        user.add(d);
        user.add(e);
        user.add(f);
        user.add(j);

        System.out.println(ANSI_GREEN2 + ANSI_BLACK + "Список Set: " + ANSI_RESET);
        for (Object s : user) {
                System.out.println(ANSI_GREEN2 + ANSI_BLACK + s + ANSI_RESET);
            }

        Set<User> linkedHashSet = new LinkedHashSet<>(user);

        System.out.println(ANSI_BLUE2 + ANSI_BLACK + "Список LinkedHashSet: " + ANSI_RESET);
        for (Object s : linkedHashSet) {
            System.out.println(ANSI_BLUE2 + ANSI_BLACK + s + ANSI_RESET);
        }

        SortedSet<User> treeSet = new TreeSet<>(user);

        System.out.println(ANSI_YELLOW + ANSI_BLACK + "Список TreeSet: " + ANSI_RESET);
        for (Object s : treeSet) {
            System.out.println(ANSI_YELLOW + ANSI_BLACK + s + ANSI_RESET);
        }
    }
}
class User implements  Comparable<User>{
    String name;
    Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Користувач -> (" +
                "Ім\'я -> '" + name + '\'' +
                ", Роки -> " + age +
                ')';
    }

    @Override
    public int compareTo(User o) {
        int s = this.name.compareTo(o.name);
        if (s == 0){
            s = this.age.compareTo(o.age);
        }
        return s;
    }
}

