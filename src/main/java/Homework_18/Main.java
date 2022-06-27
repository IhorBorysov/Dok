package Homework_18;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyEntry myEntry=new MyEntry(1,"Ihor");
        myEntry.add_ob();
        myEntry.add_ob();
        myEntry.rem_k(01);
        myEntry.rem_v("re");
        myEntry.set_keys();
        myEntry.list_value();
        myEntry.all_map();
    }
}

class MyEntry<K,V>{
    private K key;
    private V valye;


    public MyEntry(K key, V valye) {
        this.key = key;
        this.valye = valye;
    }

    Map<Integer,String> baza = new HashMap<>();

    public void add_ob() {
            System.out.println("Введіть ключ -> ");
            Scanner scanner = new Scanner(System.in);
            int K = Integer.parseInt(scanner.next());
            System.out.println("Ведіть ім'я -> ");
            Scanner scanner1 = new Scanner(System.in);
            String V = scanner1.next();
            baza.put(K, V);
            System.out.println(baza.toString());
    }

    public  void rem_k(int n){
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.next());
        baza.remove(n);
        System.out.println(baza.toString());
    }

    public  void rem_v(String value) {
        for (Map.Entry<Integer, String> i :baza.entrySet()){
            if (i.getValue().equals(value)){
                int rem= i.getKey();
                baza.remove(rem);
                System.out.println(baza.toString());
            }
        }
    }

    public void set_keys(){
        Set<Integer> integers = baza.keySet();
        System.out.println(integers);

    }

    public  void list_value(){
        Collection<String> values = baza.values();
        System.out.println(values);
    }

    public void all_map(){
        for (Map.Entry<Integer,String> baza:baza.entrySet()){
            System.out.println("ID -> "+baza.getKey()+" Ім'я -> "+baza.getValue());
        }
    }



    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValye() {
        return valye;
    }

    public void setValye(V valye) {
        this.valye = valye;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyEntry<?, ?> myEntry)) return false;
        return Objects.equals(getKey(), myEntry.getKey()) && Objects.equals(getValye(), myEntry.getValye()) && Objects.equals(baza, myEntry.baza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValye(), baza);
    }

    @Override
    public String toString() {
        return "MyEntry{" +
                "key=" + key +
                ", valye=" + valye +
                ", baza=" + baza +
                '}';
    }
}
