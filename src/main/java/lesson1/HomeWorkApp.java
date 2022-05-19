package lesson1;

public class HomeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
        System.out.println("--");
    }

    static void checkSumSign() {
        int a = 5;
        int b = 7;

        if (a + b >= 0) {
            System.out.println("Сумма чисел " + a + " и " + b + " положительная");
        } else {
            System.out.println("Сумма чисел " + a + " и " + b + " отрицательная");
        }
    }

    static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        int a = 5;
        int b = 7;

        if (a >= b) {System.out.println("a>=b");}
        else {System.out.println("a<b");}
    }
}
