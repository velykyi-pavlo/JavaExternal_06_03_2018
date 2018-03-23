package com.velykyi.model.impl;


import com.velykyi.model.Coordinates;
import com.velykyi.model.Fly;

/**
 * Created by pavlo on 3/19/18.
 */
public class Plane extends Vehicle implements Fly {

    private int height;
    private int amountOfPassangers;
    private Engine eng;

    private class PlaneEngine extends Engine{

        @Override
        public void launch() {
            System.out.println( "start plane engine");
        }
    }

    @Override
    public void fly() {
        eng = new PlaneEngine();
        eng.launch();
        System.out.println("Plane is flying");
    }

    public Plane(int price, int speed, int yearsOfMade, Coordinates coordinates, int height, int amountOfPassangers) {
        super(price, speed, yearsOfMade, coordinates);
        this.height = height;
        this.amountOfPassangers = amountOfPassangers;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Plane{" + super.toString()+
                "height=" + height +
                ", amountOfPassangers=" + amountOfPassangers +
                '}';
    }
}
