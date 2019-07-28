package com.company.carsFiles;

public class Trucks extends Car {

    private int loadCapacity;

    public Trucks(String name, int price, int maxSpeed, int fuelConsump, int loadCapacity) {
        setName(name);
        setPrice(price);
        setMaxSpeed(maxSpeed);
        setFuelConsump(fuelConsump);
        this.loadCapacity = loadCapacity;
    }

    public String toString() {

        return getName() + "," + getPrice() + "," + getMaxSpeed() + "," + getFuelConsump() + "," + loadCapacity + ",Trucks;";
    }

}
