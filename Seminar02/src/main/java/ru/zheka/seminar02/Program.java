package ru.zheka.seminar02;

import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '•';

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static final int win = 4;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random random = new Random();

    /**
     * инициализация игрового поля
     */

    private static void initialize() {
        // Установим размерность игрового поля
        fieldSizeX = 5;
        fieldSizeY = 5;


        field = new char[fieldSizeX][fieldSizeY];
        // Пройдем по всем элементам массива
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                // Проинициализируем все элементы массива DOT_EMPTY (признак пустого поля)
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     */
    private static void printField() {
        System.out.print("⌐");
        for (int i = 0; i < fieldSizeY * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSizeY; j++)
                System.out.print(field[i][j] + "|");

            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    /*
    ход игрока
     */
    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Введите координаты X и Y через пробел от 1 до "
                    + fieldSizeX + " по X, "
                    + fieldSizeY + " по Y >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;

    }

    /**
     * @param x координата
     * @param y координата
     * @return возвращает что ячейка пустоя
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * проверка корректоности ввода
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    static boolean checkWin(char c) {
        // Проверка по трем горизонталям
//        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
//        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
//        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;
//
//        // Проверка по диагоналям
//        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
//        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
//
//        // Проверка по трем вертикалям
//        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
//        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
//        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;
        // Проверка по горизонтали
        for (int i = 0; i <field.length ; i++) {
            int check = 0;
            for (int j = 0; j < field[i].length; j++) {
                if(field[i][j] == c){
                    check++;
                    if(check == win){
                        return true;
                    }
                } else {
                    check = 0;
                }
            }
        }

        // Проверка по вертикали
        for (int j = 0; j < field.length; j++) {
            int check = 0;
            for (int i = field.length - 1; i >= 0; i--) {
                if (field[i][j] == c) {
                    check++;
                    if (check == win) {
                        return true;
                    }
                } else {
                    check = 0;
                }
            }
        }
        // Проверка по вертикали



        return false;
    }

    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkGame(char c, String str) {
        if (checkWin(c)) {
            System.out.println(str);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Нечья");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkGame(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkGame(DOT_AI, "Компьютер победил!"))
                    break;
            }
            System.out.println("Желаете сыграть еще раз? (Y - да)");
            if (!SCANNER.next().equalsIgnoreCase("Y"))
                break;
        }
    }

}
