package Homework_17;

import java.util.*;

public class Main {
    public static void main(String[] args) {
            CommodityContainer commodityUseCase = new CommodityContainer();
            commodityUseCase.execute();
        }
    }

    class CommodityContainer {
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_ccc = "\u001B[41m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_GREEN2 = "\u001B[42m";
        public static final String ANSI_BLUE2 = "\u001B[44m";
        public static final String ANSI_WHITE = "\u001B[47m";

        private List<Commodity> commodities = new ArrayList<>();
        public Scanner scanner;

        public CommodityContainer() {
            this.scanner = new Scanner(System.in);
        }

        public void execute() {
            Menu.menu();
            menu();
        }

        public void menu() {
            while (true){
                System.out.print(ANSI_BLUE+"Введіть номер дії -> "+ ANSI_RESET);
                String s = String.valueOf(scanner.next());
                switch (s) {
                    case "1" -> {
                        vizyal();
                        System.out.println(ANSI_YELLOW + "Ви вибрали додате товар." + ANSI_RESET);
                        add_tovar();
                    }
                    case "2" -> {
                        vizyal();
                        System.out.println(ANSI_YELLOW + "Ви вибрали видалити товар." + ANSI_RESET);
                        remov_tovar();
                    }
                    case "3" -> {
                        vizyal();
                        System.out.println(ANSI_YELLOW + "Ви вибрали замінити товар." + ANSI_RESET);
                        peremen_tovar();
                    }
                    case "4" -> {
                        vizyal();
                        System.out.println(ANSI_YELLOW + "Ви вибрали сортувати за назвоню." + ANSI_RESET);
                        sortByName();
                    }
                    case "5" -> {
                        vizyal();
                        System.out.println(ANSI_YELLOW + "Ви вибрали сортувати за довжиною." + ANSI_RESET);
                        sortByLenght();
                    }
                    case "6" -> {
                        vizyal();
                        System.out.println(ANSI_YELLOW + "Ви вибрали сортувати за шириною." + ANSI_RESET);
                        sortByWidth();
                    }
                    case "7" -> {
                        vizyal();
                        System.out.println(ANSI_YELLOW + "Ви вибрали сортувати за вагою." + ANSI_RESET);
                        sortByWeight();
                    }
                    case "8" -> {
                        vizyal();
                        System.out.println(ANSI_YELLOW + "Ви вибрали вивести елемент колекції який ви ввели." + ANSI_RESET);
                        vuvid_tovar();
                    }
                    case "9" -> {
                        vizyal();
                        System.out.print(ANSI_WHITE + ANSI_RED + "Завершення роботи!                                                    " + ANSI_RESET);
                        System.exit(0);
                    }
                    default -> {
                        System.out.println(ANSI_RED + "Некоректний вибір спробуй ще раз!" + ANSI_RESET);
                    }
                }
            }
        }

        void add_tovar(){
            vizyal1();
            System.out.println(ANSI_PURPLE+"Який товар бажаєте добавити? "+ ANSI_RESET);
            System.out.println(ANSI_PURPLE+"Якщо хочете зупинити дію додавання товару ведіть слово: "+ ANSI_RESET +ANSI_RED+"break"+ ANSI_RESET);
            vizyal1();
            String stop = "break";

            while (true) {
                System.out.print(ANSI_BLUE+"Введіть товар -> ");
                String name = scanner.next();

                if (!stop.equals(name)) {
                    vizyal();
                    System.out.print(ANSI_BLUE+"Введіть довжину товару -> ");
                    Integer lenght = scanner.nextInt();
                    vizyal();

                    System.out.print(ANSI_BLUE+"Введіть ширину товару -> ");
                    Integer width = scanner.nextInt();
                    vizyal();

                    System.out.print(ANSI_BLUE+"Введіть вагу товару -> ");
                    Integer weight = scanner.nextInt();
                    vizyal();

                    commodities.add(new Commodity(name, lenght, width, weight));
                }else {
                    System.out.println(ANSI_RED+"Ви зупинили дію додавання товару!"+ ANSI_RESET);
                    System.out.println(ANSI_GREEN+"Товар який ви ввели було додано."+ ANSI_RESET);
                    Menu.menu();
                    break;
                }
            }
        }

        void remov_tovar(){
            System.out.print(ANSI_ccc+"Введіть назву товар для видалення -> "+ ANSI_RESET+" ");
            String name = scanner.next();
            Iterator<Commodity> iterator = commodities.iterator();

            while (iterator.hasNext()) {
                Commodity next = iterator.next();
                if (next.getName().equals(name)) {
                    commodities.remove(next);
                    System.out.println(ANSI_GREEN + "Товар успішно видалено." + ANSI_RESET);
                }else {
                    System.out.println(ANSI_RED + "Товар не найдено." + ANSI_RESET);
                    break;
                }
                break;
            }
            Menu.menu();
        }

        void peremen_tovar(){
            System.out.print(ANSI_GREEN2 + ANSI_BLACK + "Введіть назву товару для зміниння -> "+ ANSI_RESET+"  ");
            String name1 = scanner.next();
            System.out.print(ANSI_GREEN2 + ANSI_BLACK + "Введіть довжину товару для зміниння -> "+ ANSI_RESET+"  ");
            int lenght1 = scanner.nextInt();
            System.out.print(ANSI_GREEN2 + ANSI_BLACK + "Введіть ширину товару для зміниння -> "+ ANSI_RESET+"  ");
            int width1 = scanner.nextInt();
            System.out.print(ANSI_GREEN2 + ANSI_BLACK + "Введіть вагу товару для зміниння -> "+ ANSI_RESET+"  ");
            int weight1 = scanner.nextInt();

            System.out.print(ANSI_BLUE2 + ANSI_BLACK + "Введіть назву товару на яку замінити -> "+ ANSI_RESET+"  ");
            String rename = scanner.next();
            System.out.print(ANSI_BLUE2 + ANSI_BLACK + "Введіть довжину товару на яку замінити -> "+ ANSI_RESET+"  ");
            int relenght = scanner.nextInt();
            System.out.print(ANSI_BLUE2 + ANSI_BLACK + "Введіть ширину товару на яку замінити -> "+ ANSI_RESET+"  ");
            int rewidth = scanner.nextInt();
            System.out.print(ANSI_BLUE2 + ANSI_BLACK + "Введіть вагу товару на яку замінити -> "+ ANSI_RESET+"  ");
            int reweight = scanner.nextInt();

            Iterator<Commodity> iterators = commodities.iterator();

            while (iterators.hasNext()) {
                Commodity next = iterators.next();
                if ((next.getName().equals(name1))||
                        (next.getLenght().equals(lenght1))||
                        (next.getWidth().equals(width1))||
                        (next.getWeight().equals(weight1))) {
                    int index = commodities.indexOf(next);
                    commodities.set(index, new Commodity(rename, relenght, rewidth, reweight));
                }
            }
            Menu.menu();
        }

        void vuvid_tovar(){
            System.out.println(ANSI_GREEN+"Вивід товару який ви додали: "+ANSI_RESET);
            for (Commodity s : commodities) {
                System.out.println(s);
            }
            vizyal();
            Menu.menu();
        }
        public void sortByName() {
            commodities.sort(Metod.ComparatorByName());
            for (Commodity s : commodities) {
                System.out.println(s);
            }
            vizyal();
            Menu.menu();
        }
        public void sortByLenght() {
            commodities.sort(Metod.ComparatorByLenght());
            for (Commodity s : commodities) {
                System.out.println(s);
            }
            vizyal();
            Menu.menu();
        }
        public void sortByWidth() {
            commodities.sort(Metod.ComparatorByWidth());
            for (Commodity s : commodities) {
                System.out.println(s);
            }
            vizyal();
            Menu.menu();
        }
        public void sortByWeight() {
            commodities.sort(Metod.ComparatorByWeight());
            for (Commodity s : commodities) {
                System.out.println(s);
            }
            vizyal();
            Menu.menu();
        }

        void vizyal(){
            for (int r=1;r<=70;r++){
                System.out.print(ANSI_RESET+"-");
            }
            System.out.println('\n');
        }
        void vizyal1(){
            for (int r=1;r<=70;r++){
                System.out.print(ANSI_WHITE+" "+ANSI_RESET);
            }
            System.out.println('\n');
        }
    }

    class Commodity {

        @Override
        public String toString() {
            return "Товар -> (" +
                    "Назва -> '" + name + '\'' +
                    ", Довжина -> " + lenght +
                    ", Ширина -> " + width +
                    ", Вага -> " + weight +
                    ')';
        }

        private String name;
        private Integer lenght;
        private Integer width;
        private Integer weight;

        public Commodity(String name, Integer lenght, Integer width, Integer weight) {
            this.name = name;
            this.lenght = lenght;
            this.width = width;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getLenght() {
            return lenght;
        }

        public void setLenght(Integer lenght) {
            this.lenght = lenght;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(int reweight) {
            this.weight = weight;
        }
    }

    class Metod{
        public static Comparator<Commodity> ComparatorByName(){
            return  new Comparator<Commodity>() {
                @Override
                public int compare(Commodity o1, Commodity o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            };

        }

        public static Comparator<Commodity> ComparatorByLenght(){
            return new Comparator<Commodity>() {
                @Override
                public int compare(Commodity o1, Commodity o2) {
                    return o1.getLenght().compareTo(o2.getLenght());
                }
            };
        }

        public static Comparator<Commodity> ComparatorByWidth(){
            return new Comparator<Commodity>() {
                @Override
                public int compare(Commodity o1, Commodity o2) {
                    return o1.getWidth().compareTo(o2.getWidth());
                }
            };
        }

        public static Comparator<Commodity> ComparatorByWeight(){
            return new Comparator<Commodity>() {
                @Override
                public int compare(Commodity o1, Commodity o2) {
                    return o1.getWeight().compareTo(o2.getWeight());
                }
            };
        }
    }