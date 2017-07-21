package com.qac.tasks;

public class Basic {
    public static void main(String[] args) {
        String hw = "Hello World";
        System.out.println(hw);

        printHW("Hello World");
        System.out.println(returnHW());

        System.out.println(sumNums(2, 4, true));

        for (int i = 0; i <= 10; i++) {
            System.out.println(sumNums(i, 4, true));
        }

        int[] arrInt = new int[10];
        for (int i = 0; i <= 10; i++) {
            arrInt[i] = i;
        }

        for (int a : arrInt) {
            System.out.println(sumNums(a, 4, true));
        }

        for (int a : arrInt) {
            System.out.println(a);
        }
    }

    private static void printHW(String hw) {
        System.out.println(hw);
    }

    private static String returnHW() {
        return "Hello World";
    }

    private static int sumNums(int x, int y, boolean b) {
        if (x == 0 || y == 0) {
            return x + y;
        }

        if (x == 0) {
            return y;
        } else if (y == 0) {
            return x;
        }

        if (b) {
            return x + y;
        }
        return x * y;
    }
}
