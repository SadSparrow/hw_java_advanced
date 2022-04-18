package org.sparrow.tasks.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс Calculator предназначен для сложения, вычитания, деления или умножения дробных чисел.
 * @author Алиса Воробьева
 */
public class Calculator {

    /**
     *Не позволяет создавать экземпляры данного класса
     */
    private Calculator(){
    }

    /**
     * Метод считывает введенные пользователем 2 числа и символ операции.<br>Допустимо введение дробных чисел.<br>
     * Результат вычисления округляется до 4-х знаков после запятой и выводится в консоль.
     * @throws IllegalArgumentException если второе число равно нулю и выбрана операция деления
     * @throws IllegalArgumentException если операция указана некорректно
     * @see Calculator#parseCharOperation(String) 
     */
    public static void calculate() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) { // закрытие ресурсов

            System.out.println("Введите первое число: "); //считываем первое число
            double a = Double.parseDouble(reader.readLine().replace(",", ".")); // обработка дробного числа с запятой

            System.out.println("Введите второе число: "); //считываем второе число
            double b = Double.parseDouble(reader.readLine().replace(",", "."));

            System.out.println("Укажите операцию: "); //считываем символ операции
            char operation = parseCharOperation(reader.readLine());

            if (operation == '/' && b == 0) { // выбрасываем исключение при делении на ноль
                throw new IllegalArgumentException("\nНедопустимая операция: деление на ноль");
            }

            String resultMsg = "Результат вычисления: %.4f"; // формат вывода для результата вычисления
            switch (operation) { // вычисление
                case '+' -> System.out.printf(resultMsg, (a + b));
                case '-' -> System.out.printf(resultMsg, (a - b));
                case '*' -> System.out.printf(resultMsg, (a * b));
                case '/' -> System.out.printf(resultMsg, (a / b));
                default -> throw new IllegalArgumentException(String.format("%nОперация указана некорректно: [%s]%nДопустимые значения: [+], [-], [*], [/]", operation));
            }
        } catch (NumberFormatException e) {
            System.out.println("Необходимо ввести число");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает символьное обозначение операции для вычисления.
     * <br>Выбрасывает исключение, если введенаая строка не соответствует допустимым операциям:
     * <ul>
     *     <li>для операции сложения: +
     *     <li>для операции вычитания: -
     *     <li>для операции умножения: *
     *     <li>для операции деления: /
     * </ul>
     * @param str строка, введенная пользователем
     * @return символ операции для вычисления
     * @throws IllegalArgumentException если операция указана некорректно
     */
    private static char parseCharOperation(String str) {
        str = str.replace(" ", ""); // убираем пробелы
        if (str.length() != 1) {
            throw new IllegalArgumentException(String.format("%nОперация указана некорректно: [%s]%nДопустимые значения: [+], [-], [*], [/]", str));
        }
        return str.charAt(0);
    }
}