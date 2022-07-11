package Homework_22;

public class Main {
    public static void main(String[] args) {
        Lamda lamda = new Lamda();
        lamda.lamda(203,777,555,((a, b, c) -> {
            int max_ches = Math.max(a, b);
            max_ches = Math.max(max_ches, c);
            System.out.println("Максимальне значення -> " + max_ches);
            return 0;
        }),((a, b, c) -> {
            int median = Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
            System.out.println("Середнє значення -> " + median);
            return 0;
        }),((a, b, c) -> {
            System.out.println("Сума значень -> " + (a + b + c));
            return (a + b + c);
        }));
    }
}

class Lamda{
    void lamda(int number_1, int number_2, int number_3, Ches mAx, Ches sUm , Ches sEr){
        mAx.tr_ches(number_1,number_2,number_3);
        sUm.tr_ches(number_1,number_2,number_3);
        sEr.tr_ches(number_1,number_2,number_3);
    }
}
