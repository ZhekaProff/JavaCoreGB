package ru.zheka.seminar03.classes;

import ru.zheka.seminar03.abstractClasses.Worker;
import ru.zheka.seminar03.interfaces.SortByName;
import ru.zheka.seminar03.interfaces.SortBySalaryDesc;


import java.util.Arrays;

/**
 * класс для сортировки массива с Worker
 */
public class WorkerSorting implements SortBySalaryDesc, SortByName {
    private final Worker[] workers;
    public WorkerSorting(Worker[] workers) {
        this.workers = workers;
    }

    /**
     * сортировка массива по salary
     */
    @Override
    public void sortBySalaryDesc(){
        Arrays.sort(workers,(e1,e2)-> Double.compare(e1.getSalary(), e2.getSalary()));
    }

    /**
     * сортировка массива по имени
     */
    @Override
    public void sortByName(){
        Arrays.sort(workers);
    }

    /**
     * печать массива
     */
    public void printWorkers(){
        for (Worker worker: workers) {
            System.out.println(worker.getName() + ": " + worker.getSalary());
        }
    }

}
