package com.velykyi.model.impl;


import com.velykyi.model.Coordinates;
import com.velykyi.model.Move;

/**
 * Created by pavlo on 3/19/18.
 */
public class Car extends Vehicle implements Move {
    private Engine eng;

    public Car(int price, int speed, int yearsOfMade, Coordinates coordinates) {
        super(price, speed, yearsOfMade, coordinates);
    }

    private class CarEngine extends Engine{
        @Override
        public void launch() {
            System.out.println("Start car engine");
        }
    }

    @Override
    public void move() {
        eng = new CarEngine();
        eng.launch();
        System.out.println("Car is moving");
    }

    @Override
    public String toString() {
        return "Car{" + super.toString()+ " }";
    }
}
