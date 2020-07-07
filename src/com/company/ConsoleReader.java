package com.company;

import java.util.Scanner;

public class ConsoleReader {

    public static Expression readEnter(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().replaceAll("\\s", "");
        if (!Util.checkOrder(s)) throw new RuntimeException("Ошибка: неверный ввод данных.");
        else {
            Expression expression = Util.enterToExpression(s);
            if (expression.getA()>10 || expression.getA()<1 ||
                    expression.getB()<1 || expression.getB()>10)
                throw new RuntimeException("Ошибка: неверный ввод данных. Введенное числа меньше 1 или больше 10");
            return expression;
        }
    }

}
