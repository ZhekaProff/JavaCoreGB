package ru.zheka.seminar04;

import ru.zheka.seminar04.Exceptions.MyArrayDataException;
import ru.zheka.seminar04.Exceptions.MyArraySizeException;

public class Main {
    public static String[][] array = {
            {"0", "1", "0", "0"},
            {"0", "0", "2", "0"},
            {"0", "0", "0", "ц"},
//            {"0", "0", "0", "1"},
            {"0", "4", "0", "0"}
    };
    public static int maxLength = 4;

    public static void main(String[] args) {
        try {
            System.out.println("Sum of elements: " + sumArray(array));
        } catch (MyArraySizeException e) {
            System.out.println("Invalid array size!");
        } catch (MyArrayDataException e) {
            System.out.println("Invalid data at row " + (e.getRow()+1) + " and column " + (e.getColumn()+1));
        }
    }
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != maxLength || array[0].length != maxLength) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    int num = Integer.parseInt(array[i][j]);
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}

