package com.company;

public class Expression {
    private int a;
    private int b;
    private char operator;

    public Expression(int a, int b, char operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}
