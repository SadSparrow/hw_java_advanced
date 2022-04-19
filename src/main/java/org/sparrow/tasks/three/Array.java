package org.sparrow.tasks.three;

import java.util.Arrays;
import java.util.Random;

public class Array {

    public static void main(String[] args) {

        int[] array = new Random().ints(20, -10, 11).toArray();
        System.out.println("Начальный массив:");
        System.out.println(Arrays.toString(array));

        int maxLessThanZero = Arrays.stream(array).filter(i -> i < 0).max().orElseThrow();
        int minAboveZero = Arrays.stream(array).filter(i -> i > 0).min().orElseThrow();

        System.out.printf("Максимальный отрицательный элемент: [%d], ", maxLessThanZero);
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == maxLessThanZero) {
                index = i;
                System.out.printf("его первый индекс в массиве: [%d]%n", index);
                array[i] = minAboveZero;
                break;
            }
        }
        System.out.println("Выполнена замена первого максимального отрицательного элемента на минимальный положительный:");
        System.out.println(Arrays.toString(array));

        System.out.printf("Минимальный положительный элемент: [%d], ", minAboveZero);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == minAboveZero && i != index) {
                System.out.printf("его первый индекс в массиве: [%d]%n", i);
                array[i] = maxLessThanZero;
                break;
            }
        }
        System.out.println("Выполнена замена первого минимального положительного элемента на максимальный отрицательный:");
        System.out.println(Arrays.toString(array));
    }
}
