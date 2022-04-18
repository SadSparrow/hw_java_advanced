package org.sparrow.tasks.two;

import org.sparrow.tasks.one.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите номер задания: (1 - калькулятор, 2 - массив строк)");
            switch (reader.readLine()) {
                case "1" -> Calculator.calculate();
                case "2" -> Array.getLongestWord();
                default -> System.out.println("Номер задания указан некорректно");
            }
        }
    }
}
