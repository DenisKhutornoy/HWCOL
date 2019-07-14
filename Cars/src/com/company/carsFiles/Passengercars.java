package com.company.carsFiles;

public class Passengercars extends Car {
    private int passengerCapacity;

    public Passengercars(String name, int price, int maxSpeed, int fuelConsump, int passengerCapacity) {
        this.name = name;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.fuelConsump = fuelConsump;
        this.passengerCapacity = passengerCapacity;
    }

    public String toString() {

        return name + "," + price + "," + maxSpeed + "," + fuelConsump + "," + passengerCapacity + ",Passengercars;";
    }
}
