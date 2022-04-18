package org.sparrow.tasks.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array {

    private Array() {
    }

    public static void getLongestWord() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) { // закрытие ресурсов

            int arrSize = getArrSize(reader);

            String[] words = new String[arrSize];
            int[] countCharsInWord = new int[arrSize];

            System.out.println("Введите слова");
            for (int i = 0; i < arrSize; i++) {
                System.out.printf("Строка №%d: %n", i + 1);
                words[i] = reader.readLine();
                countCharsInWord[i] = words[i].length();
            }

            int max = Arrays.stream(countCharsInWord).max().orElseThrow();

            for (int i = 0; i < arrSize; i++) {
                if (countCharsInWord[i] == max) {
                    System.out.printf("Самое длинное слово в массиве: %s", words[i]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getArrSize(BufferedReader reader) throws IOException {
        int arrSize;
        System.out.println("Введите размер массива: "); //считываем размер массива
        while (true) {
            try {
                arrSize = Integer.parseInt(reader.readLine());
                if (arrSize <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести число больше нуля");
            }
        }
        return arrSize;
    }
}