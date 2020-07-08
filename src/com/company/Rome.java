package com.company;

public enum Rome {
    I(1), V(5), X(10), XL(40), L(50), XC(90), C(100);

    int value;

    Rome(int value) {
        this.value = value;
    }

    public static String ArabianToRome(int a) {
        StringBuilder sb = new StringBuilder("");
        sb.append(tens(a/10)).append(units(a%10));
        return sb.toString();
    }

    public static StringBuilder units(int a) {
        StringBuilder sb = new StringBuilder("");
        switch (a) {
            case 1:
            case 2:
            case 3:
                for (int i = 0; i < a; i++) sb.append("I");
                break;
            case 4:
                sb.append("IV");
                break;
            case 5:
                sb.append("V");
                break;
            case 6:
            case 7:
            case 8:
                sb.append("V");
                for (int i = 0; i < a - 5; i++) sb.append("I");
                break;
            case 9:
                sb.append("IX");
                break;

        }
        return sb;
    }
    public static StringBuilder tens(int a) {
        StringBuilder sb = new StringBuilder("");
        switch (a) {
            case 1:
            case 2:
            case 3:
                for (int i = 0; i < a; i++) sb.append("X");
                break;
            case 4:
                sb.append("XL");
                break;
            case 5:
                sb.append("L");
                break;
            case 6:
            case 7:
            case 8:
                sb.append("L");
                for (int i = 0; i < a - 5; i++) sb.append("X");
                break;
            case 9:
                sb.append("XC");
                break;
            case 10: sb.append("C");
        }
        return sb;
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

}
