package com.velykyi.model.impl;


import com.velykyi.model.Coordinates;

/**
 * Created by pavlo on 3/19/18.
 */
public abstract class Vehicle {
    private int price;
    private int speed;
    private int yearsOfMade;
    private Coordinates coordinates;

    public Vehicle(int price, int speed, int yearsOfMade, Coordinates coordinates) {
        this.price = price;
        this.speed = speed;
        this.yearsOfMade = yearsOfMade;
        this.coordinates = coordinates;
    }

    protected abstract class Engine{
        public abstract void launch();
    }

    @Override
    public String toString() {
        return "{" +
                "price=" + price +
                ", speed=" + speed +
                ", yearsOfMade=" + yearsOfMade +

                '}';
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getYearsOfMade() {
        return yearsOfMade;
    }

    public void setYearsOfMade(int yearsOfMade) {
        this.yearsOfMade = yearsOfMade;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
