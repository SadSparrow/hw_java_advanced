package org.sparrow.tasks.four_six.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractCalculatorTest {
    protected static final double firstOperand = 2000;
    protected static final double secondOperand = 2;
    protected final Calculator calculator;
    protected final PrintStream standardOut = System.out;
    protected final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    public AbstractCalculatorTest(Calculator calculator) {
        this.calculator = calculator;
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void makeCalculation() {
        Assertions.assertAll(
                () -> assertEquals(calculator.makeCalculation(firstOperand, secondOperand, Operation.ADD), firstOperand + secondOperand),
                () -> assertEquals(calculator.makeCalculation(firstOperand, secondOperand, Operation.SUBTRACT), firstOperand - secondOperand),
                () -> assertEquals(calculator.makeCalculation(firstOperand, secondOperand, Operation.MULTIPLY), firstOperand * secondOperand),
                () -> assertEquals(calculator.makeCalculation(firstOperand, secondOperand, Operation.DIVIDE), firstOperand / secondOperand),
                () -> assertThrows(ArithmeticException.class, () -> calculator.makeCalculation(firstOperand, 0, Operation.DIVIDE)),
                () -> assertThrows(IllegalArgumentException.class, () -> Operation.valueOf("operation not exist"))
        );
    }

    @Test
    void printResult() {
        calculator.printResult();
        double result = calculator.makeCalculation(firstOperand, secondOperand, Operation.ADD);
        calculator.printResult();
        Assertions.assertEquals(String.format(Locale.FRANCE, "No calculations were made yet%n%,.2f", result), outputStream.toString().trim());
    }
}