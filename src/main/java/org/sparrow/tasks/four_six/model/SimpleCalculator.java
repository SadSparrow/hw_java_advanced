package org.sparrow.tasks.four_six.model;

import java.util.logging.Level;

public class SimpleCalculator extends AbstractCalculator {
    private Double result = null;

    @Override
    protected void saveResult(double result) {
        LOG.log(Level.INFO, "save result: {0}", result);
        this.result = result;
    }

    @Override
    public void printResult() {
        System.out.println(result == null ? ERROR_MSG : formatResult(result));
    }
}
