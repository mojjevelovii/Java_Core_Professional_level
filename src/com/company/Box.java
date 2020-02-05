package com.company;

/*Задача:
Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
Класс Box, в который можно складывать фрукты. Коробки условно
сортируются по типу фрукта, поэтому в одну коробку нельзя сложить
и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;
Сделать метод getWeight(), который высчитывает вес коробки.
Задать вес одного фрукта и их количество: вес яблока – 1.0f,
апельсина – 1.5f (единицы измерения не важны);
Внутри класса Box сделать метод compare(), который позволяет
сравнить текущую коробку с той, которую подадут в compare() в
качестве параметра. true – если их массы равны, false в
противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
Написать метод, который позволяет пересыпать фрукты из текущей коробки
в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку
с апельсинами. Соответственно, в текущей коробке фруктов не остается,
а в другую перекидываются объекты, которые были в первой;
Не забываем про метод добавления фрукта в коробку.
*/

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addAllFruits(List<T> fruits) {
        this.fruits.addAll(fruits);
    }

    public void pourToAnotherBox(Box<T> anotherBox) {
        anotherBox.addAllFruits(fruits);
        fruits.clear();
    }

    public float getWeight() {
        if (fruits.size() == 0) {
            return 0;
        } else {
            return fruits.size() * fruits.get(0).getWeight();
        }
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }
}
