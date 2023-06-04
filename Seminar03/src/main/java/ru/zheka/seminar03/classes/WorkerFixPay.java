package ru.zheka.seminar03.classes;

import ru.zheka.seminar03.abstractClasses.Worker;

public class WorkerFixPay extends Worker  {

    private final double monthlySalary; // Фиксированная месячная оплата

    public WorkerFixPay(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateMonthlySalary() {
        return monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }


    @Override
    public int compareTo(Worker o) {
        return  this.getName().compareTo(o.getName());
    }
}
