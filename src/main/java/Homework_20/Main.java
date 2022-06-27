package Homework_20;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Metods1 metods1=new Metods1();
        metods1.start();

        Metods2 metods2=new Metods2("Потік 1");
        try{
            metods2.t.join();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        System.out.println("\n"+"Головний потік завершився");
    }
}
class Metods1 extends Thread{

    void  method(){
        System.out.println("Введіть цифру:");
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        int n0 = 1;
        int n1 = 1;
        int n2;
        System.out.print(n0+" ");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
        }
        System.out.print(n1+" ");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
        }
        for(int i = 3; i <= number; i++){
            n2=n0+n1;
            try{
                Thread.sleep(1000);
            }catch (Exception e){
            }
            System.out.print(n2+" ");
            n0=n1;
            n1=n2;
        }
        System.out.println();
    }
    @Override
    public void run() {
        try {
            method();
        }catch (Exception e){
            e.getMessage();
            e.getStackTrace();

        }
    }
}

class Metods2 implements  Runnable{
    Thread t;
    String name;

    Metods2(String name_threads){
        name=name_threads;
        t=new Thread(this,name_threads);
        t.start();
    }

    void  method(){
        System.out.println("Введіть цифру:");
        Scanner scanner=new Scanner(System.in);
        int number = scanner.nextInt();
        int fib[] = new int[number];
        if(number>=0)
            fib[0] = 0;
        if(number>=1)
            fib[1] = 1;
        for(int i=2;i<number;i++)
            fib[i] = fib[i-1] + fib[i-2];
        for(int i=number-1;i>=0;i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(fib[i] + " ");
        }
    }

    @Override
    public void run() {
        try {
            method();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
    }
}