package com.velykyi.model.impl;


import com.velykyi.model.Coordinates;
import com.velykyi.model.Fly;
import com.velykyi.model.Move;

/**
 * Created by pavlo on 3/20/18.
 */
public class BetMobile extends Vehicle implements Move, Fly {

    private Engine eng;

    public BetMobile(int price, int speed, int yearsOfMade, Coordinates coordinates) {
        super(price, speed, yearsOfMade, coordinates);
    }

    private class BetMobileEngine extends Engine{

        @Override
        public void launch() {
            System.out.println("start betMobileEngine");
        }
    }

    @Override
    public void fly() {
        eng = new BetMobileEngine();
        eng.launch();
        System.out.println("Betmobile is flying");
    }

    @Override
    public void move() {
        eng = new BetMobileEngine();
        eng.launch();
        System.out.println("betMobile is moving");
    }

    @Override
    public String toString() {
        return "BetMobile{" + super.toString()+" }";
    }
}
