package com.company.mathClasses;

import com.company.carsFiles.Car;
import com.company.carsFiles.Passengercars;
import com.company.carsFiles.Trucks;
import com.company.interfeces.CarsStorage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CarsFile implements CarsStorage {

    @Override
    public ArrayList<Car> readCars() {
        ArrayList<Car> park = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("InputCars.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] readBytes = new byte[0];
        try {
            readBytes = new byte[fis.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fis.read(readBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String file = new String(readBytes);

        String[] stringCars = separator(file, ";\r\n");

        for (int i = 0; i < stringCars.length; i++) {
            String[] field = separator(stringCars[i], ",");

            String name = field[0];
            int price = Integer.parseInt(field[1]);
            int maxSpeed = Integer.parseInt(field[2]);
            int fuelConsump = Integer.parseInt(field[3]);
            int special = Integer.parseInt(field[4]);
            String type = field[5];

            park.add(makeCar(name, price, maxSpeed, fuelConsump, special, type));
        }
        return park;
    }

    @Override
    public void writeCars(ArrayList<Car> carstowrite) {
        int size = carstowrite.size();
        try (FileWriter writer = new FileWriter("output.txt", false)) {
            for (int i = 0; i < size - 1; i++) {
                writer.write(carstowrite.get(i).toString() + "\n");
            }
            writer.write(carstowrite.get(size - 1).toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Car makeCar(String name, int price, int maxSpeed, int fuelConsump, int special, String type) {
        if (type.equals("Trucks")) {
            Trucks car = new Trucks(name, price, maxSpeed, fuelConsump, special);
            return car;
        } else {
            Passengercars car = new Passengercars(name, price, maxSpeed, fuelConsump, special);
            return car;
        }
    }

    public String[] separator(String text, String symbol) {
        String[] lines = text.split(symbol);
        return lines;
    }
}

