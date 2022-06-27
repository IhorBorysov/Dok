package Homework_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

   protected static List<String> work = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean i = true;

        while (i = true) {
            System.out.print("Введіть слова -> ");
            String stop = "break";
            String words = scanner.nextLine();

            vizyal();

            if (!stop.equals(words)) {
                work.add(words);
                System.out.println("Вивід масива: ");
                for (String s : work) {
                    System.out.println(s);
                }
                vizyal();
            } else {
                System.err.print("Ви зупинили програму!");
            }
            wors_S();
            vizyal();
            wors_5();
            vizyal();
        }
    }

   static void wors_S() {
        Pattern pattern=Pattern.compile("^s",Pattern.CASE_INSENSITIVE);

        for (String k : work) {
            Matcher matcher=pattern.matcher(k);
            if (matcher.find()){
                System.out.println("Слово що починається на букву \"S\" -> "+k);
            }
        }
    }

    static void wors_5() {
        for (String l : work) {
            if (l.length()>5){
                System.out.println("Слово має кількість букв більше ніж 5 -> " +l);
            }
        }
    }

    static void vizyal(){
            for (int r=1;r<=50;r++){
                System.out.print("-");
            }
            System.out.println('\n');
        }
}


