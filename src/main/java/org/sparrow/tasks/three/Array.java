package org.sparrow.tasks.three;

import java.util.Arrays;
import java.util.Random;

public class Array {

    public static void main(String[] args) {

        int[] array = new Random().ints(20, -10, 11).toArray();

        int maxLessThanZero = Arrays.stream(array).filter(i -> i < 0).max().orElseThrow();
        int minAboveZero = Arrays.stream(array).filter(i -> i > 0).min().orElseThrow();

        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == maxLessThanZero) {
                index = i;
                array[i] = minAboveZero;
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == minAboveZero && i != index) {
                array[i] = maxLessThanZero;
                break;
            }
        }
    }
}
