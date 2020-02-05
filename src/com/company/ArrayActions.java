package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayActions<T> {

    /*
    1. Написать метод, который меняет два элемента массива местами
    (массив может быть любого ссылочного типа);
     */
    public T[] swipeItem(T[] array, T item1, T item2) {
        ArrayList<T> arrayList = toArrayList(array);
        int positionOne = arrayList.indexOf(item1);
        int positionTwo = arrayList.indexOf(item2);

        replaceAtPosition(item2, arrayList, positionOne);

        replaceAtPosition(item1, arrayList, positionTwo);

        return arrayList.toArray(array);
    }

    private void replaceAtPosition(T item, ArrayList<T> arrayList, int position) {
        arrayList.remove(position);
        arrayList.add(position, item);
    }


    /*
    2. Написать метод, который преобразует массив в ArrayList;
    */
    public ArrayList<T> toArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
