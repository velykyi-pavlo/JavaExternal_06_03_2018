package com.velykyi.model.util;

import com.velykyi.model.Coordinates;
import com.velykyi.model.Fly;
import com.velykyi.model.Move;
import com.velykyi.model.Swim;
import com.velykyi.model.impl.*;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class SearchUtils {
    List<Vehicle> list;

    public void setList(List<Vehicle> list) {
        this.list = list;
    }

    public List<Vehicle> getList() {
        return list;
    }

    public void getListVechicleByYears(int yearFrom, int yearsTo) {
        this.list = list.stream()
                .filter(i -> (i.getYearsOfMade() >= yearFrom) && (i.getYearsOfMade() <= yearsTo))
                .sorted(Comparator.comparing(i -> i.getYearsOfMade()))
                .collect(Collectors.toList());
    }

    public void getVechicleBySpeed(int speed) {
        this.list = list.stream()
                .filter(i -> i.getSpeed() >= speed)
                .sorted(Comparator.comparing(i -> i.getSpeed()))
                .collect(Collectors.toList());
    }

    public void getVechicleByPrice(int priceFrom, int priceTo) {
        this.list = list.stream()
                .filter(i -> (i.getPrice() <= priceTo) && (i.getPrice() >= priceFrom))
                .sorted(Comparator.comparing(i -> i.getPrice()))
                .collect(Collectors.toList());
    }

    public void getListVechicleByType(String sc) {
//        this.list = new ArrayList<>(list2);
        switch (sc) {
            case "move": {// get all cars
                this.list = list.stream()
                        .filter(vehicle -> vehicle instanceof Move)
                        .collect(Collectors.toList());
                break;
            }
            case "swim": { // get All ship
                this.list = list.stream()
                        .filter(vehicle -> vehicle instanceof Swim)
                        .collect(Collectors.toList());
                break;
            }
            case "fly": { // get All ship
                this.list = list.stream()
                        .filter(vehicle -> vehicle instanceof Fly)
                        .collect(Collectors.toList());
                break;
            }
            default:
                this.list = list;
        }

    }


}

