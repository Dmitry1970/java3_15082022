package ru.gb.baranov.homework1;

// 2. Написать метод, который преобразует массив в ArrayList

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5};

//        Варианты:
//        List<Integer> integers = Arrays.asList(ints);
//        List<Integer> intslist = Arrays.stream(ints).toList();

        List<Integer> ints2 = new ArrayList<>();
        for (Integer number : ints) {
            ints2.add(number);

        }
        System.out.println(Arrays.toString(ints));
    }
}

