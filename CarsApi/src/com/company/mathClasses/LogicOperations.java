package com.company.mathClasses;

import com.company.carsFiles.Car;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LogicOperations {


    public <T> ArrayList<T> getArrayListFromStream(Stream<T> stream) {
        List<T> list = stream.collect(Collectors.toList());
        ArrayList<T> arrayList = new ArrayList<T>(list);
        return arrayList;
    }

    public void printList(ArrayList<Car> cars) {
        Iterator<Car> iter = cars.iterator();
        while (iter.hasNext()) {
            String printCar = iter.next().toString();
            System.out.println(printCar);
        }
    }
}
