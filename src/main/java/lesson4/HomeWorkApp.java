package lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {

    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {
        int hor, ver;
        for (int i = 0; i < SIZE; i++) {
            hor = 0;
            ver = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    hor++;
                } else {
                    hor = 0;
                }
                if (map[j][i] == symb) {
                    ver++;
                } else {
                    ver = 0;
                }
                if (hor == DOTS_TO_WIN || ver == DOTS_TO_WIN) {
                    return true; //проверка по горизонтали и вертикали
                }
                if (isDiagWin(i, j, symb)) return true;  //проверка по любой диагонали для данной ячейки
            }

        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y +
                1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isDiagWin(int x, int y, char symb) {
        int checkWin = 0;
        if (x + DOTS_TO_WIN <= SIZE && y + DOTS_TO_WIN <= SIZE) {
            for (int i = 0; i < DOTS_TO_WIN; i++) {
                if (map[x + i][y + i] == symb) {
                    checkWin++;
                } else break;
            }
            if (checkWin == DOTS_TO_WIN) return true;
        }
        checkWin = 0;
        if (x + DOTS_TO_WIN <= SIZE && y - DOTS_TO_WIN + 1 >= 0) {
            for (int i = 0; i < DOTS_TO_WIN; i++) {
                if (map[x + i][y - i] == symb) {
                    checkWin++;
                } else break;
            }
            if (checkWin == DOTS_TO_WIN) return true;
        }
        checkWin = 0;
        if (x - DOTS_TO_WIN + 1 >= 0 && y + DOTS_TO_WIN <= SIZE) {
            for (int i = 0; i < DOTS_TO_WIN; i++) {
                if (map[x - i][y + i] == symb) {
                    checkWin++;
                } else break;
            }
            if (checkWin == DOTS_TO_WIN) return true;
        }
        checkWin = 0;
        if (x - DOTS_TO_WIN + 1 >= 0 && y - DOTS_TO_WIN + 1 >= 0) {
            for (int i = 0; i < DOTS_TO_WIN; i++) {
                if (map[x - i][y - i] == symb) {
                    checkWin++;
                } else break;
            }
            if (checkWin == DOTS_TO_WIN) return true;
        }
        return false;
    }
}

