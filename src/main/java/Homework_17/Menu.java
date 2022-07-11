package Homework_17;

public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_ccc = "\u001B[43m";
    public static final String ANSI_qqq = "\u001B[44m";

    public static void menu(){

        String menu = "МЕНЮ";
        System.out.println(ANSI_ccc + ANSI_BLACK + "                                "+ menu+"                                  "+ANSI_RESET);

        System.out.println(ANSI_GREEN+ "1)  "+ ANSI_BLUE +"Додати товар.\n"
                +ANSI_GREEN+ "2)  "+ ANSI_BLUE +"Видалити товар.\n"
                +ANSI_GREEN+ "3)  "+ ANSI_BLUE +"Замінити товар.\n"
                +ANSI_GREEN+ "4)  "+ ANSI_BLUE +"Сортувати за назвоню.\n"
                +ANSI_GREEN+ "5)  "+ ANSI_BLUE +"Сортувати за довжиною.\n"
                +ANSI_GREEN+ "6)  "+ ANSI_BLUE +"Сортувати за шириною.\n"
                +ANSI_GREEN+ "7)  "+ ANSI_BLUE +"Сортувати за вагою.\n"
                +ANSI_GREEN+ "8)  "+ ANSI_BLUE +"Виводимо і-тий елемент колекції який ви ввели.");
        System.out.println(ANSI_GREEN+ "9)  "+ ANSI_PURPLE +"Вийти з програми."+ANSI_RESET);
        vizyal();
    }
    static void vizyal(){
        for (int r=1;r<=70;r++){
            System.out.print(ANSI_RESET+ANSI_qqq+"="+ANSI_RESET);
        }
        System.out.println('\n');
    }
}
