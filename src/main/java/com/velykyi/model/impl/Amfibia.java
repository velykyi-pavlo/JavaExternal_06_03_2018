package com.velykyi.model.impl;


import com.velykyi.model.Coordinates;
import com.velykyi.model.Move;
import com.velykyi.model.Swim;

/**
 * Created by pavlo on 3/20/18.
 */
public class Amfibia extends Vehicle implements Move, Swim {

    private Engine eng;

    public Amfibia(int price, int speed, int yearsOfMade, Coordinates coordinates) {
        super(price, speed, yearsOfMade, coordinates);
    }

    private class AmfibiaEngine extends Engine {

        @Override
        public void launch() {
            System.out.println("start amfibia Engine");
        }
    }


    @Override
    public void move() {
        eng = new AmfibiaEngine();
        eng.launch();
        System.out.println("Amfibia is moving");
    }

    @Override
    public void swim() {
        eng = new AmfibiaEngine();
        eng.launch();
        System.out.println("Amfibia is swiming");
    }

    @Override
    public String toString() {
        return "Amfibia{ " + super.toString() + "}";
    }
}
