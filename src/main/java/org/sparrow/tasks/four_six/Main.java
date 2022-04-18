package org.sparrow.tasks.four_six;

import org.sparrow.tasks.four_six.model.MemoryCalculator;
import org.sparrow.tasks.four_six.model.Operation;
import org.sparrow.tasks.four_six.model.SimpleCalculator;

public class Main {

    public static void main(String[] args) {
        double x = 2000.05;
        double y = 2.01;
        System.out.println("========SimpleCalculator========");
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        simpleCalculator.printResult();
        simpleCalculator.makeCalculation(x, y, Operation.ADD);
        simpleCalculator.makeCalculation(x, y, Operation.SUBTRACT);
        simpleCalculator.printResult();
        simpleCalculator.makeCalculation(x, y, Operation.MULTIPLY);
        simpleCalculator.makeCalculation(x, y, Operation.DIVIDE);
        simpleCalculator.printResult();
        System.out.println("========MemoryCalculator========");
        MemoryCalculator memoryCalculator = new MemoryCalculator();
        memoryCalculator.printAllResults();
        memoryCalculator.makeCalculation(x, y, Operation.ADD);
        memoryCalculator.makeCalculation(x, y, Operation.SUBTRACT);
        memoryCalculator.printResult();
        double z = memoryCalculator.makeCalculation(x, y, Operation.MULTIPLY);
        memoryCalculator.makeCalculation(x, z, Operation.DIVIDE);
        memoryCalculator.printResult();
        memoryCalculator.makeCalculation(memoryCalculator.getResultByIndex(1), memoryCalculator.getResultByIndex(0), Operation.ADD);
        memoryCalculator.printAllResults();
        memoryCalculator.clearAllResults();
        memoryCalculator.printAllResults();

//      Catch exceptions:
        calculateWithException(() -> memoryCalculator.getResultByIndex(10));
        calculateWithException(() -> memoryCalculator.makeCalculation(x, 0, Operation.DIVIDE));
        calculateWithException(() -> memoryCalculator.makeCalculation(x, y, Operation.valueOf("operation not exist")));
    }

    @FunctionalInterface
    private interface CalculatorFunctionalInterface {
        void getCalculatorException() throws Exception;
    }

    private static void calculateWithException(CalculatorFunctionalInterface myInterface) {
        try {
            myInterface.getCalculatorException();
        } catch (Exception e) {
            System.out.println("catch " + e.getClass().getSimpleName());
        }
    }
}
