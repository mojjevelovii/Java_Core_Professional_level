package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayActions<String> arrayActions = new ArrayActions<>();
        String[] arr = new String[]{"A", "B", "C", "D", "E", "F"};
        String[] arrayNew = arrayActions.swipeItem(arr, "B", "F");
        System.out.println(Arrays.toString(arrayNew));


        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());

        orangeBox.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());

        System.out.println(appleBox.compare(orangeBox2));
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.compare(appleBox2));

        appleBox2.pourToAnotherBox(appleBox);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());



    }
}
