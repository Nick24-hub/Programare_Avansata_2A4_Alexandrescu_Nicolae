package com.lab7;

public class Token {
    private final int i1;
    private final int i2;
    private final int value;

    public Token(int i1, int i2, int value) {
        this.i1 = i1;
        this.i2 = i2;
        this.value = value;
    }

    public int getI1() {
        return i1;
    }

    public int getI2() {
        return i2;
    }

    public int getValue() {
        return value;
    }
}
