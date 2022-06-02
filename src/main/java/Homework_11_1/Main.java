package Homework_11_1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static void patt_a(String text) {
        Pattern pattern = Pattern.compile("a.+?\s", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> texts = new ArrayList<String>();

        while (matcher.find()) {
            texts.add(matcher.group());
            System.out.println("В масив було додано слова -> " + texts);
        }
    }
    public static void main(String[] args) {
        System.out.print("Введіть слова: ");
        String text;
        Scanner scanner = new Scanner(System.in);
        text = scanner.nextLine();
        patt_a(text);
    }
}
