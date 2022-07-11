package Homework_11_3;

public class Main {
    static void per(String str){
        String s = str.replaceFirst("Java","C#");
        String s1 = str.replaceAll("Java","C#");
        System.out.println(s);
        System.out.println(s1);
    }
    public static void main(String[] args) {
        String str = "I love Java more than my friend. Java is so beautiful.";
        System.out.println(str);
        per(str);
    }
}