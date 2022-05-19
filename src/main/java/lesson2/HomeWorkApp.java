package lesson2;

public class HomeWorkApp {
    public static void main(String[] args) {
        caseTenTwenty(2, 5);
        casePositive(1);
        caseNoPositive(-1);
        printStringNum("sddssda fdfdds", 3);

        caseLeapYear(2400);
    }

    static boolean caseTenTwenty(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    static void casePositive(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " положительное");
        } else {
            System.out.println("Число " + a + " отрицательное");
        }
    }

    static boolean caseNoPositive(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    static void printStringNum(String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    static void caseLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 > 0 || year % 400 == 0)) {
            System.out.println("Год " + year + " високосный");
        } else {
            System.out.println("Год " + year + " не високосный");
        }
    }
}
