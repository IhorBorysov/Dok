package Homework_19;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            ArrayList<Employee> arrayList = new ArrayList<>();
            Employee employee = new Employee("Ihor", 1, 4532311);
            Employee employee1 = new Employee("Mark", 2, 876543);
            Employee employee2 = new Employee("Dima", 3, 123445);
            Employee employee3 = new Employee("Vasya", 4, 65432);
            Employee employee4 = new Employee("Andriy", 5, 435675);

            arrayList.add(employee);
            arrayList.add(employee1);
            arrayList.add(employee2);
            arrayList.add(employee3);
            arrayList.add(employee4);
            arrayList.add(employee);

            Salary salary = new Salary(975442123, "Олег");
            Salary salary_null = new Salary();

            Methods methods = new Methods();

            methods.serialize(employee);
            methods.deserialize();

            methods.serialize(arrayList);
            methods.deserialize();

            methods.serialize(salary);
            methods.deserialize(salary_null);
        }
}
class Employee implements Serializable {
    private String name;
    private int id;
    private transient int salary;

    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && id == employee.id && salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + name +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}

class Methods {

    public void serialize(Employee objects) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("filename.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(objects);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public void serialize(ArrayList o) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("filename.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("filename.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object employee = objectInputStream.readObject();
        System.out.println(employee);
    }


    public void serialize(Salary salary) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("filename.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(salary);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public void deserialize(Salary o) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("filename.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        o = (Salary) objectInputStream.readObject();
        System.out.println(o);
    }
}

class Salary implements Serializable {
    private int time_number;
    private String name;

    public Salary() {
    }

    public Salary(int time_number, String name) {
        this.time_number = time_number;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return time_number == salary.time_number && Objects.equals(name, salary.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time_number, name);
    }

    @Override
    public String toString() {
        return "Salary{" +
                "time_number=" + time_number +
                ", name='" + name + '\'' +
                '}';
    }
}
