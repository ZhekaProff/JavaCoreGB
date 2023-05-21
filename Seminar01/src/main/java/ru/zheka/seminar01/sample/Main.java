package ru.zheka.seminar01.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ru.zheka.seminar01.methods.MathematicalActions.actions;

public class Main {
    public static void main(String[] args) {
        int firstCount;
        int secondCount;
        float result = 0;
        String action;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("Введите первое число: ");
            firstCount = Integer.parseInt(reader.readLine());
            System.out.print("Выберите операцию (+, -, *, /): ");
            action = reader.readLine();
            System.out.print("Введите второе число: ");
            secondCount = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Результат: ");
        actions(firstCount,secondCount,action);
    }
}
