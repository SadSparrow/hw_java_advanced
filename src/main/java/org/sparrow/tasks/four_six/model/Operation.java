package org.sparrow.tasks.four_six.model;

public enum Operation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String operationSymbol;

    Operation(String operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public String getOperationSymbol() {
        return operationSymbol;
    }
}
