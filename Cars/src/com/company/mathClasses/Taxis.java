package com.company.mathClasses;

import com.company.carsFiles.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Taxis {
    CarsFile cf = new CarsFile();

    public ArrayList<Car> park = cf.readCars();
    Iterator<Car> iter = park.iterator();


    Comparator<Car> lambdaContraction = (Car firstCar, Car secondCar) -> {
        if (firstCar.fuelConsump > secondCar.fuelConsump) {
            return 1;
        } else if (firstCar.fuelConsump < secondCar.fuelConsump) {
            return -1;
        } else {
            return 0;
        }
    };

    Comparator<Car> methodImplementation = new Comparator<>() {
        @Override
        public int compare(Car o1, Car o2) {
            if (o1.fuelConsump > o2.fuelConsump) {
                return 1;
            } else if (o1.fuelConsump < o2.fuelConsump) {
                return -1;
            } else {
                return 0;
            }
        }
    };


    private LogicOperations lo = new LogicOperations();

    public int sum = lo.calculateTotalPrice(park);

//     сортировка с использованием  реализации интерфейса

    public ArrayList<Car> sort = lo.sort(park, methodImplementation);

    //сортировка с использованием  ссылки на метод

    //  public ArrayList<Car> = lo.sort(park, CarsComparator::compare);

    //сортировка с использованием лямбда-выражения

    // public ArrayList<Car> = lo.sort(park, lambdaContraction);


    public ArrayList<Car> speedCar = lo.selectbySpeed(park, 80, 90);


    public void writeCars() {
        cf.writeCars(sort);
    }
}
