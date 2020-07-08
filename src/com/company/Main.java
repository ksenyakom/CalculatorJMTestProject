package com.company;

public class Main {
    public static boolean rome = false;

    public static void main(String[] args) {
        while (true) {
            Expression expression = ConsoleReader.readEnter("Input: ");
            int  result =calculate(expression);

            System.out.println("Output: \n " + (rome?Rome.ArabianToRome(result):result));

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
