package com.velykyi.model.impl;


import com.velykyi.model.Coordinates;
import com.velykyi.model.Swim;

/**
 * Created by pavlo on 3/19/18.
 */
public class Ship extends Vehicle implements Swim {

    private int amountOfpassangers;
    private String address;
    private Engine eng;

    public Ship(int price, int speed, int yearsOfMade, Coordinates coordinates, int amountOfpassangers, String address) {
        super(price, speed, yearsOfMade, coordinates);
        this.amountOfpassangers = amountOfpassangers;
        this.address = address;
    }

    private class ShipEngine extends Engine{

        @Override
        public void launch() {
            System.out.println("start ship engine");
        }
    }

    public static class LifeBoat {
        private int boatId;
        public static void down() {
            System.out.println("lifeboat on water!");
        }
        public void swim() {
            System.out.println("lifeboat swim");
        }
    }

    public int getAmountOfpassangers() {
        return amountOfpassangers;
    }

    public void setAmountOfpassangers(int amountOfpassangers) {
        this.amountOfpassangers = amountOfpassangers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {

        return "Ship{" + super.toString()+
                "amountOfpassangers=" + amountOfpassangers +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public void swim() {
        eng = new ShipEngine();
        eng.launch();
        System.out.println("Ship is swimming");
    }
}

