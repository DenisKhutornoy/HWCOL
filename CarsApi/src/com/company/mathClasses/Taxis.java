package com.company.mathClasses;

import com.company.carsFiles.Car;

import java.util.*;
import java.util.function.Predicate;

public class Taxis {

    CarsFile cf = new CarsFile();
    public ArrayList<Car> park = cf.readCars();


    Comparator<Car> lambdaContraction = (Car firstCar, Car secondCar) -> {
        if (firstCar.getFuelConsump() > secondCar.getFuelConsump()) {
            return 1;
        } else if (firstCar.getFuelConsump() < secondCar.getFuelConsump()) {
            return -1;
        } else {
            return 0;
        }
    };

    Predicate<Car> selectBySpeed = x -> x.getMaxSpeed() >= 90 && x.getMaxSpeed() <= 100;

    Comparator<Car> methodImplementation = new Comparator<>() {
        @Override
        public int compare(Car o1, Car o2) {
            if (o1.getFuelConsump() > o2.getFuelConsump()) {
                return 1;
            } else if (o1.getFuelConsump() < o2.getFuelConsump()) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    private LogicOperations lo = new LogicOperations();


    public void streamStart(ArrayList<Car> park) {

        ArrayList<Car> sortedpark = lo.getArrayListFromStream(park.stream().sorted(lambdaContraction));
        cf.writeCars(sortedpark);
        System.out.println(" Total price of park:");

        int sum = park.stream().reduce(0, (x, y) -> {
            x = x + y.getPrice();
            return x;
        }, (x, y) -> x + y);

        System.out.println(sum);
        System.out.println(" Cars, that was selected by speed:");
        ArrayList<Car> selectedCars = lo.getArrayListFromStream(park.stream().filter(selectBySpeed));
        lo.printList(selectedCars);

    }
}
