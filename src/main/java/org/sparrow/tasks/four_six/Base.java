package org.sparrow.tasks.four_six;

import org.sparrow.tasks.four_six.model.Calculator;
import org.sparrow.tasks.four_six.model.MemoryCalculator;
import org.sparrow.tasks.four_six.model.Operation;
import org.sparrow.tasks.four_six.model.SimpleCalculator;
import org.sparrow.tasks.four_six.util.CalculatorInputParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Base {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Выберите тип калькулятора: 1-SimpleCalculator, 2-MemoryCalculator");
            Calculator calculator = null;
            do {
                switch (reader.readLine()) {
                    case "1" -> calculator = new SimpleCalculator();
                    case "2" -> calculator = new MemoryCalculator();
                    default -> System.out.println("Тип указан неверно. Выберите тип калькулятора: 1-SimpleCalculator, 2-MemoryCalculator");
                }
            } while (calculator == null);

            String agreement;
            do {
                double firstOperand = readDouble(reader, "Введите первое число: ");
                double secondOperand = readDouble(reader, "Введите второе число: ");

                Operation operation;
                do {
                    System.out.println("Укажите операцию: [+], [-], [*], [/]");
                    operation = CalculatorInputParser.parseOperation(reader.readLine());
                } while (operation == null);

                calculator.makeCalculation(firstOperand, secondOperand, operation);
                calculator.printResult();

                do {
                    System.out.println("Продолжить вычисления? [да/нет]");
                    agreement = reader.readLine().toLowerCase(Locale.ROOT);
                } while (!agreement.equals("да") && !agreement.equals("нет"));

            } while (agreement.equals("да"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Double readDouble(BufferedReader reader, String msg) throws IOException {
        Double value;
        do {
            System.out.println(msg);
            value = CalculatorInputParser.parseDouble(reader.readLine());
        } while (value == null);
        return value;
    }
}
