package com.company;


public class Util {
    public static Expression enterToExpression(String s) {
        String[] sNumbers = s.split("[-+*/]");
        int a, b;
        if (sNumbers[0].matches("([IVX])+")) {
            if (checkRomeOrder(sNumbers[0]) && checkRomeOrder(sNumbers[1])) {
                a = romeToArabian(sNumbers[0]);
                b = romeToArabian(sNumbers[1]);
            } else throw new RuntimeException("Ошибка: римские цифры введены неверно");
        } else {
            a = Integer.parseInt(sNumbers[0]);
            b = Integer.parseInt(sNumbers[1]);
        }
        char operator = s.charAt(sNumbers[0].length());
        // System.out.println("a=" + a + " b = " + b + " оператор " + operator);
        return new Expression(a, b, operator);
    }

    public static int romeToArabian(String s) {
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            Rome rome = Rome.valueOf(s.substring(i - 1, i));
            sum += rome.value;
        }
        Rome firstRome = Rome.valueOf(s.substring(0, 1));
        Rome lastRome = Rome.valueOf(s.substring(s.length() - 1, s.length()));
        if (firstRome.value < lastRome.value) return lastRome.value - sum;
        else return lastRome.value + sum;
    }

    public static boolean checkOrder(String s) {
        return s.matches("\\d{1,2}([-+*/])\\d{1,2}") ||
                s.matches("([IVX])+([-+*/])([IVX])+");
    }

    public static boolean checkRomeOrder(String s) {
        int[] mass = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            mass[i] = Rome.valueOf(s.substring(i, i + 1)).value;
        }
        boolean grow = false, decrease = false;
        for (int i = 0; i < mass.length-1; i++) {
            if (mass[i] < mass[i + 1]) grow = true;
            if (mass[i] > mass[i + 1]) decrease = true;
        }
        if (grow && decrease) return false;
        return true;
    }
}
