package org.sparrow.tasks.four_six.model;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractCalculator implements Calculator {
    protected static final Logger LOG = Logger.getLogger(AbstractCalculator.class.getName());
    protected static final String ERROR_MSG = "No calculations were made yet";

    @Override
    public double makeCalculation(double firstOperand, double secondOperand, Operation operation) {
        double result;
        switch (operation) {
            case ADD -> {
//                LOG.info(String.format("operand %s is added to operand %s", secondOperand, firstOperand));
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

    protected abstract void saveResult(double result);

    protected String formatResult(double result) {
        return String.format(Locale.FRANCE, "%,.2f", result);
    }
}
