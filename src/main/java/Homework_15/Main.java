package Homework_15;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ZooStryct zoo = new ZooStryct();
        Person person = new Person("Ігор Борисов", 19);

        zoo.addPersonToList(person);
        zoo.addAnimalToList(person, new Animal("Кіт", "Мурчик"));
        zoo.addAnimalToList(person, new Animal("Собака", "Барбос"));
        zoo.addAnimalToList(new Person("Настя Цвітун", 20),
                new Animal("Хом\'як", "Стьопа"));
        zoo.addAnimalToList(new Person("Роман Зубрицький", 35),
                new Animal("Собака", "Жужа"));
        zoo.addAnimalToList(new Person("Олег Каднічанський", 45),
                new Animal("Хом\'як", "Василь"));
        zoo.addAnimalToList(new Person("Ярослав Гнатюк", 20),
                new Animal("Кролик", "Болік"));

        zoo.showAll();
        System.out.println(" ");
        zoo.removeAnimal(person ,new Animal("Собака", "Жужа"));
        zoo.removePerson(new Person("Олег Каднічанський", 45));
        zoo.showAll();
    }

}

class ZooStryct {

    Map<Person, List<Animal>> zooClub = new HashMap<>();

    public Scanner scanner;

    public ZooStryct() {
        this.scanner = new Scanner(System.in);
    }

    public void addPersonToList(Person person) {
        zooClub.put(person, new ArrayList<>());
    }

    public void addAnimalToList(Person person, Animal animal) {
        if (zooClub.containsKey(person)) {
            List<Animal> animals = zooClub.get(person);
            animals.add(animal);
            zooClub.put(person, animals);
        } else {
            zooClub.put(person, List.of(animal));
        }
    }

    public void removeAnimal(Person person, Animal animal) {
        List<Animal> animals = zooClub.get(person);
        animals.remove(animal);
        zooClub.put(person, animals);
    }

    public void removePerson(Person person) {
        zooClub.remove(person);
    }

    public void showAll() {
        Set<Map.Entry<Person, List<Animal>>> entries = zooClub.entrySet();

        for (Map.Entry<Person, List<Animal>> entry : entries) {
            System.out.println(entry.getKey() + " тварина:");
            for (Animal animal: entry.getValue()) {
                System.out.println("  " + animal);
            }
        }
    }


}


class Person {
    private String name;
    private Integer age;

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

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Oсоба -> (" +
                "Ім\'я -> '" + name + '\'' +
                ", Роки -> " + age +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class Animal {
    private String animal_type;
    private String animal_name;

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public Animal(String animal_type, String animal_name) {
        this.animal_type = animal_type;
        this.animal_name = animal_name;
    }

    @Override
    public String toString() {
        return "Тварина -> (" +
                "Тип тварини -> '" + animal_type + '\'' +
                ", Ім\'я тварини -> " + animal_name +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(animal_type, animal.animal_type) && Objects.equals(animal_name, animal.animal_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animal_type, animal_name);
    }
}