package Homework_23;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static void main(String[] args) {

        List<Person> peopleList = new ArrayList<>();

        Person people = new Person("Ігор", 19, "Чоловік");
        Person people1 = new Person("Петро",25,"Чоловік");
        Person people2 = new Person("Діма",23,"Чоловік");
        Person people3 = new Person("Андрій",60,"Чоловік");
        Person people4 = new Person("Віка", 43, "Жінка");
        Person people5 = new Person("Діма", 30, "Чоловік");
        Person people6 = new Person("Вася",70,"Чоловік");
        Person people7 = new Person("Аліна",12,"Жінка");
        Person people8 = new Person("Настя",55,"Жінка");
        Person people9 = new Person("Роман", 47, "Чоловік");
        Person people10 = new Person("Юля", 32, "Жінка");

        peopleList.add(people);
        peopleList.add(people1);
        peopleList.add(people2);
        peopleList.add(people3);
        peopleList.add(people4);
        peopleList.add(people5);
        peopleList.add(people6);
        peopleList.add(people7);
        peopleList.add(people8);
        peopleList.add(people9);
        peopleList.add(people10);

        Stream<Person> stream = peopleList.stream();

        Scanner scanner = new Scanner(System.in);

        System.out.println(ANSI_GREEN+ "1)  "+ ANSI_BLUE +"Вибрати чоловіків-військовозобов'язаних (від 18 до 27 років).\n"
                +ANSI_GREEN+ "2)  "+ ANSI_BLUE +"Знайти середній вік серед чоловіків.\n"
                +ANSI_GREEN+ "3 , 33)  "+ ANSI_BLUE +"Знайти кількість потенційно працездатних людей у вибірці (тобто від 18 років і з огляду на що жінки виходять в 55 років, а чоловік в 60).\n"
                +ANSI_GREEN+ "4)  "+ ANSI_BLUE +"Відсортувати колекцію людей за ім'ям в зворотному алфавітному порядку.\n"
                +ANSI_GREEN+ "5 , 55)  "+ ANSI_BLUE +"Відсортувати колекцію людей спочатку за ім’ям, а потім за віком.\n"
                +ANSI_GREEN+ "6)  "+ ANSI_BLUE +"Знайти найстаршу людину.\n"
                +ANSI_GREEN+ "7)  "+ ANSI_BLUE +" Знайти наймолодшу людину.\n"
                +ANSI_GREEN+ "8)  "+ ANSI_BLUE +"Вивести скільки є чоловіків.\n"
                +ANSI_GREEN+ "9)  "+ ANSI_BLUE +"Вивести скільки є жінок.\n"
                +ANSI_GREEN+ "10)  "+ ANSI_BLUE +"Вивеcти всіх жінок в яких ім’я починається на “A”."+ANSI_RESET);

        System.out.print("Введіть дію -> ");
        int s = scanner.nextInt();

        switch (s) {
            case 1 -> {
                stream.filter((age) -> {
                    if (age.getSex().equals("Чоловік")) {
                        return age.getAge() >= 18 && age.getAge() <= 27;
                    }
                    return false;
                }).forEach(System.out::println);
                System.out.println(stream);
            }
            case 2 -> {
                double asDouble = stream.filter(age -> {
                    return age.sex.equals("Чоловік");
                }).mapToDouble(age1 -> Double.parseDouble(String.valueOf(age1.age))).average().getAsDouble();
                System.out.println(asDouble);
            }
            case 3 -> {
                       stream.filter(age->{
                if (age.getSex().equals("Чоловік")){
                return age.getAge() >= 18 && age.getAge() <= 60;}
                return false;}).forEach(System.out::println);
            }
            case 33 -> {
                stream.filter(age_woman->{
                if (age_woman.getSex().equals("Жінка")){
                    return age_woman.getAge() >= 18 && age_woman.getAge() <= 55;
                 }
                return  false;}).forEach(System.out::println);
            }
            case 4 -> {
                stream.sorted(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {return o2.name.compareTo(o1.name);}
                }).forEach(System.out::println);
            }
            case 5 -> {
                stream.sorted(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {return o1.age.compareTo(o2.age);}
                    }).forEach(System.out::println);
            }
            case 55 -> {
                stream.sorted(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {return o1.name.compareTo(o2.name);}
                }).forEach(System.out::println);
            }
            case 6 -> {
                Optional<Person> first = stream.min(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {return o2.age.compareTo(o1.age);}
                });
                System.out.println("Найстарша людина -> "+first);
            }
            case 7 -> {
                Optional<Person> first = stream.min(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {return o1.age.compareTo(o2.age);}
                });
                System.out.println("Наймолодща людина -> "+first);
            }
            case 8 -> {
                double number=stream.filter(sex->{return sex.sex.equals("Чоловік");}).count();
                System.out.println(number);
            }
            case 9 -> {
                double number_2=stream.filter(sex->{return sex.sex.equals("Жінка");}).count();
                System.out.println(number_2);
            }
            case 10 -> {
                stream.filter(name_woman->{
                    if (name_woman.getSex().equals("Жінка")){
                        Pattern pattern=Pattern.compile("^\u0410");
                        Matcher matcher=pattern.matcher(name_woman.name);
                        return matcher.find();
                    }
                    return false;
                }).forEach(System.out::println);
            }
        }
    }
}

class Person{
    public String name;
    public Integer age;
    public String sex;

    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getAge(), person.getAge()) && Objects.equals(getSex(), person.getSex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getSex());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

