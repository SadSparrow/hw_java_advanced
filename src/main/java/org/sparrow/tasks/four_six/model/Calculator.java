package org.sparrow.tasks.four_six.model;

public interface Calculator {

    double makeCalculation(double firstOperand, double secondOperand, Operation operation);

    void printResult();
}
