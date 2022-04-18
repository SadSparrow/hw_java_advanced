package org.sparrow.tasks.four_six.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class MemoryCalculator extends AbstractCalculator {
    private final ArrayList<Double> results = new ArrayList<>();

    @Override
    protected void saveResult(double result) {
        LOG.log(Level.INFO, "save result: {0}", result);
        results.add(result);
    }

    public List<Double> getAllResults() {
        return results;
    }

    public double getResultByIndex(int index) {
        if (index >= results.size()) {
            LOG.warning("index is greater than or equal to the number of calculations");
            throw new IndexOutOfBoundsException(
                    String.format("index [%d] is greater than or equal to the number of calculations [%d]", index, results.size()));
        }
        return results.get(index);
    }

    public void clearAllResults() {
        LOG.info("clear all results");
        results.clear();
        results.trimToSize();
    }

    @Override
    public void printResult() {
        System.out.println(results.isEmpty() ? ERROR_MSG : formatResult(results.get(results.size() - 1)));
    }

    public void printAllResults() {
        if (results.isEmpty()) {
            System.out.println(ERROR_MSG);
        } else {
            System.out.println("All results:");
            results.forEach(r -> System.out.println(formatResult(r)));
        }
    }
}
