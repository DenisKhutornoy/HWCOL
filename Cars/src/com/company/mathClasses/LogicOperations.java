package com.company.mathClasses;

import com.company.carsFiles.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class LogicOperations {


    public int calculateTotalPrice(ArrayList<Car> cars) {
        int sum = 0;
        for (Car i : cars) {
            sum = sum + i.price;
        }
        return sum;
    }


    public ArrayList<Car> sort(ArrayList<Car> cars, Comparator<? super Car> comparator) {
        cars.sort(comparator);

        return cars;
    }


    ArrayList<Car> selectbySpeed(ArrayList<Car> cars, int minSpeed, int maxSpeed) {
        ArrayList<Car> speedCar = new ArrayList<>();
        for (Car car : cars) {
            if (minSpeed <= car.maxSpeed && car.maxSpeed <= maxSpeed) {
                speedCar.add(car);
            }
        }
        return speedCar;
    }


    public void printList(ArrayList<Car> cars) {
        Iterator<Car> iter = cars.iterator();
        while (iter.hasNext()) {
            String printCar = iter.next().toString();
            System.out.println(printCar);
        }
    }
}
