package ru.gb.baranov.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> fruit;

    public Box(T... fruits) {

        this.fruit = new ArrayList<>(Arrays.asList(fruits));
    }

    double getWeight() {
        return fruit.stream()
                .map(Fruit::getWeight)
                .reduce(Double::sum)
                .get();
    }

    void addAll(List<? extends T> fruits) {
        // producer
        fruit.addAll(fruits);
    }

    void moveTo(Box<? super T> box) {
        // PECS
        // box - consumer
        box.addAll(fruit);
        fruit.clear();
    }


}
