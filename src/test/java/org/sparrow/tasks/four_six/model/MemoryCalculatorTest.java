package org.sparrow.tasks.four_six.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemoryCalculatorTest extends AbstractCalculatorTest {
    private final MemoryCalculator calculator = new MemoryCalculator();
    private final List<Double> results = new ArrayList<>();

    public MemoryCalculatorTest() {
        super(new MemoryCalculator());
    }

    @BeforeEach
    void fillMemory() {
        results.add(calculator.makeCalculation(firstOperand, secondOperand, Operation.ADD));
        results.add(calculator.makeCalculation(firstOperand, secondOperand, Operation.SUBTRACT));
    }

    @Test
    void getResultByIndex() {
        Assertions.assertAll(
                () -> assertDoesNotThrow(() -> calculator.getResultByIndex(1)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> calculator.getResultByIndex(100))
        );
    }

    @Test
    void getAllResults() {
        Assertions.assertEquals(results, calculator.getAllResults());
    }

    @Test
    void clearAllResults() {
        calculator.clearAllResults();
        Assertions.assertEquals(0, calculator.getAllResults().size());
    }

    @Test
    void printAllResults() {
        calculator.printAllResults();
        Assertions.assertEquals(
                String.format(Locale.FRANCE, "All results:%n%,.2f%n%,.2f", results.get(0), results.get(1)),
                outputStream.toString().trim());
    }
}