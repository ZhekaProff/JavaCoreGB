package ru.zheka.seminar03.abstractClasses;

public abstract class Worker implements Comparable<Worker>{

    private String name; // Имя сотрудника
    private double salary; // Заработная плата

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return calculateMonthlySalary();
    }

    /**
     * Абстрактный метод для расчёта среднемесячной заработной платы
     * @return расчет ЗП.
     */
    public abstract double calculateMonthlySalary();

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", salary= " + getSalary() +
                '}';
    }

}
