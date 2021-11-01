package com.wit.rest.models;

import java.io.Serializable;

public class Results<T> implements Serializable {
    private T result;

    public Results(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
