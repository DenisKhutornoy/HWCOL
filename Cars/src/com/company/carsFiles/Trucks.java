package com.company.carsFiles;

public class Trucks extends Car {

    private int loadCapacity;

    public Trucks(String name, int price, int maxSpeed, int fuelConsump, int loadCapacity) {
        this.name = name;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.fuelConsump = fuelConsump;
        this.loadCapacity = loadCapacity;
    }

    public String toString() {

        return name + "," + price + "," + maxSpeed + "," + fuelConsump + "," + loadCapacity + ",Trucks;";
    }

}
