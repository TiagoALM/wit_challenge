package com.wit.rest.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Operation implements Serializable {
    private BigDecimal a;
    private BigDecimal b;
    private String operation;

    public Operation(BigDecimal a,
                     BigDecimal b,
                     String operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
