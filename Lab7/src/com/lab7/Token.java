package com.lab7;

public class Token {
    private final int x;
    private final int y;
    private final int value;

    public Token(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "x=" + x +
                ", y=" + y +
                ", value=" + value +
                '}';
    }
}
