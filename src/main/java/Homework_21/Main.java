package Homework_21;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Metod metod = new Metod("Ihor",1000000,19,"На раслабоні");
        try {
            metod.used_reflection(metod);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        metod.method_time();
    }
}
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
 @interface Annotation {
    public String name() default "Дефолтне значення";

}

class Metod {
    @Annotation(name="Друга анотація")
    private String name;
    private int salary;
    private  int age;
    String file="fillll.txt";
    @Annotation(name="Перша анотація")
    private String proffesional;

    public Metod(String name, int salary, int age, String proffesional) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.proffesional = proffesional;
    }

    public void used_reflection(Metod metod) throws IOException {
        Class<? extends Metod> aClass = metod.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        FileWriter fileWriter=new FileWriter(file);
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Annotation.class)){
                String name = declaredField.getName();
                fileWriter.write(name);
            }
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public void method_time(){
        LocalDate localDate =LocalDate.now();
        System.out.println("Local date"+" "+localDate);
        LocalTime localTime=LocalTime.now();
        System.out.println("Local time"+" "+localTime);
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("Local date time"+" "+localDateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Metod)) return false;
        Metod metod = (Metod) o;
        return salary == metod.salary && age == metod.age && Objects.equals(name, metod.name) && Objects.equals(file, metod.file) && Objects.equals(proffesional, metod.proffesional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, age, file, proffesional);
    }

    @Override
    public String toString() {
        return "Metod{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", file='" + file + '\'' +
                ", proffesional='" + proffesional + '\'' +
                '}';
    }
}