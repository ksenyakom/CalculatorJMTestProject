package com.company;


public class Util {
    public static Expression enterToExpression(String s) {
        String[] sNumbers = s.split("[-+*/]");
        int a, b;
        if (sNumbers[0].matches("([IVX])+")) {
            if (checkRomeOrder(sNumbers[0]) && checkRomeOrder(sNumbers[1])) {
                a = Rome.romeToArabian(sNumbers[0]);
                b = Rome.romeToArabian(sNumbers[1]);
            } else throw new RuntimeException("Ошибка: римские цифры введены неверно");
        } else {
            a = Integer.parseInt(sNumbers[0]);
            b = Integer.parseInt(sNumbers[1]);
        }
        char operator = s.charAt(sNumbers[0].length());
        // System.out.println("a=" + a + " b = " + b + " оператор " + operator);
        return new Expression(a, b, operator);
    }



    public static boolean checkOrder(String s) {
        if (s.matches("\\d{1,2}([-+*/])\\d{1,2}")) {
            Main.rome = false;
            return true;
        }
        if (s.matches("([IVX])+([-+*/])([IVX])+")) {
            Main.rome = true;
            return true;
        }
        return false;
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
