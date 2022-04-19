package org.sparrow.tasks.four_six.util;

import org.sparrow.tasks.four_six.model.Operation;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorInputParser {
    private static final Logger LOG = Logger.getLogger(CalculatorInputParser.class.getName());

    private CalculatorInputParser() {
    }

    public static Double parseDouble(String str) {
        Double value;
        try {
            value = Double.parseDouble(str.replace(",", "."));
            LOG.log(Level.INFO, "get the double value from string: {0}", value);
            return value;
        } catch (NumberFormatException e) {
            LOG.warning("not a number, return null");
            return null;
        }
    }

    public static Operation parseOperation(String str) {
        Character operation = parseCharOperation(str);

        if (operation == null) {
            return null;
        }

        String logMsg = "get the operation value from string: {0}";
        switch (operation) {
            case '+' -> {
                LOG.log(Level.INFO, logMsg, Operation.ADD);
                return Operation.ADD;
            }
            case '-' -> {
                LOG.log(Level.INFO, logMsg, Operation.SUBTRACT);
                return Operation.SUBTRACT;
            }
            case '*' -> {
                LOG.log(Level.INFO, logMsg, Operation.MULTIPLY);
                return Operation.MULTIPLY;
            }
            case '/' -> {
                LOG.log(Level.INFO, logMsg, Operation.DIVIDE);
                return Operation.DIVIDE;
            }
            default -> {
                LOG.warning("Operation type not supported or invalid, return null");
                return null;
            }
        }
    }

    private static Character parseCharOperation(String str) {
        str = str.replace(" ", "");
        if (str.length() != 1) {
            LOG.warning("Operation type not supported or invalid, return null");
            return null;
        }
        return str.charAt(0);
    }
}
