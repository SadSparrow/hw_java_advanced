package org.sparrow.tasks.four_six.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractCalculator implements Calculator {
    protected static final Logger LOG = Logger.getLogger(AbstractCalculator.class.getName());
    protected static final String ERROR_MSG = "No calculations were made yet";
    protected Double firstOperand = null;
    protected Double secondOperand = null;
    protected Operation operation = null;

    @Override
    public double makeCalculation(double firstOperand, double secondOperand, Operation operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;

        double result;
        switch (operation) {
            case ADD -> {
                LOG.log(Level.INFO, "operand {0} is added to operand {1}", new Object[]{secondOperand, firstOperand});
                result = firstOperand + secondOperand;
            }
            case SUBTRACT -> {
                LOG.log(Level.INFO, "operand {0} is subtracted from operand {1}", new Object[]{secondOperand, firstOperand});
                result = firstOperand - secondOperand;
            }
            case MULTIPLY -> {
                LOG.log(Level.INFO, "operand {0} is multiplied by operand {1}", new Object[]{secondOperand, firstOperand});
                result = firstOperand * secondOperand;
            }
            case DIVIDE -> {
                if (secondOperand == 0) {
                    LOG.warning("when dividing, the second operand cannot be zero");
                    throw new ArithmeticException("Division by zero");
                }
                LOG.log(Level.INFO, "operand {0} is divided by operand {1}", new Object[]{firstOperand, secondOperand});
                result = firstOperand / secondOperand;
            }
            default -> {
                LOG.warning("Operation type not supported or invalid");
                throw new IllegalArgumentException("Invalid operation type");
            }
        }
        saveResult(result);
        return result;
    }

    public Double getFirstOperand() {
        LOG.log(Level.INFO, "get the value of the first operand: {0}", firstOperand);
        if (firstOperand == null) {
            System.out.println(ERROR_MSG);
        }
        return firstOperand;
    }

    public Double getSecondOperand() {
        LOG.log(Level.INFO, "get the value of the second operand: {0}", secondOperand);
        if (secondOperand == null) {
            System.out.println(ERROR_MSG);
        }
        return secondOperand;
    }

    public Operation getOperation() {
        LOG.log(Level.INFO, "get the value of the operation: {0}", operation);
        if (operation == null) {
            System.out.println(ERROR_MSG);
        }
        return operation;
    }

    protected abstract void saveResult(double result);

    protected String formatResult(double result) {
        return String.format("Результат вычисления: %.4f", result);
    }
}
