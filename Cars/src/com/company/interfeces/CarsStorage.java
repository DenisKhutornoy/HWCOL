package com.company.interfeces;

import com.company.carsFiles.Car;

import java.util.ArrayList;

public interface CarsStorage {

    ArrayList<Car> readCars();

    void writeCars(ArrayList<Car> carstowrite);

}
