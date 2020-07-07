package com.company;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Expression expression = ConsoleReader.readEnter("Input: ");
            System.out.println("Output: \n " + calculate(expression));

        }

    }

    public static int calculate(Expression expression) {
        switch (expression.getOperator()) {
            case '+':
                return expression.getA() + expression.getB();
            case '-':
                return expression.getA() - expression.getB();
            case '*':
                return expression.getA() * expression.getB();
            case '/':
                return expression.getA() / expression.getB();
        }
        return 0;
    }
}
