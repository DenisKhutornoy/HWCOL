package com.company;

import com.company.mathClasses.LogicOperations;
import com.company.mathClasses.Taxis;

public class TaxisMain {
    public static void main(String[] args) {


        Taxis taxis = new Taxis();
        LogicOperations lo = new LogicOperations();


        System.out.println("\nОбщая стоимость таксопарка:\n");
        System.out.println(taxis.sum);
        System.out.println("\nАвтомобили отсортированые по расходу топлива ");
        lo.printList(taxis.sort);
        System.out.println("\nАвтомобили соответствующие заданым требованиям скорости: ");
        lo.printList(taxis.speedCar);
        taxis.writeCars();

    }
}
