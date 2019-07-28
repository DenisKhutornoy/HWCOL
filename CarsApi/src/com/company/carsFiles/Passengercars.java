package com.company.carsFiles;

public class Passengercars extends Car {
    private int passengerCapacity;

    public Passengercars(String name, int price, int maxSpeed, int fuelConsump, int passengerCapacity) {
        setName(name);
        setPrice(price);
        setMaxSpeed(maxSpeed);
        setFuelConsump(fuelConsump);
        this.passengerCapacity = passengerCapacity;
    }

    public String toString() {

        return getName() + "," + getPrice() + "," + getMaxSpeed() + "," + getFuelConsump() + "," + passengerCapacity + ",Passengercars;";
    }
}
