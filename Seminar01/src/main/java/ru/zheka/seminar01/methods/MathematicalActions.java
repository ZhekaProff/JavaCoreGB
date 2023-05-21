package ru.zheka.seminar01.methods;

import static ru.zheka.seminar01.methods.Operator.*;

public class MathematicalActions {
    public static void actions(int firstCount, int secondCount, String action) {
        switch (action) {
            case "+":
                System.out.println(addition(firstCount, secondCount));
                break;
            case "-":
                System.out.println(subtraction(firstCount, secondCount));
                break;
            case "*":
                System.out.println(multiplication(firstCount, secondCount));
                break;
            case "/":
                System.out.println(division(firstCount, secondCount));
                break;
            default:
                System.out.println("Операция не распознана. Попробуйте еще раз.");
                break;

        }
    }
}
