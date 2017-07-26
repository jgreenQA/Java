package com.qac.peerprog2;

public class Spiral {
    public static void main(String[] args) {
        getSpiral(8);
    }

    public static void getSpiral(int n) {
        int finalNum = (int)Math.pow(n, 2), x = 4;
        int secondRowInit = (3 * n) + (n - x);
        int[][] pattern = new int[n][n];

        //sort spacing

        for (int i = 0; i <= pattern.length - 1; i++) {
            for (int j = 0; j <= pattern.length - 1; j++) {
                pattern[i][j] = j + 1;
            }
        }

        //printing
        for (int i = 0; i <= pattern.length - 1; i++) {
            for (int j = 0; j <= pattern.length - 1; j++) {
                if (i == 0) {
                    System.out.print(pattern[i][j] + " ");

                } else if (i == 1) {
                    if (j < n - 1) {
                        System.out.print((3 * n) + ((n - x)));
                        System.out.print(" ");
                    } else {
                        System.out.print(n + 1);
                    }
                    x--;

                } else if (i == n - 1) {
                    System.out.print(secondRowInit - (n - (j - (j + 2))));
                }
            }
            System.out.println();
        }

        //3n + (n-4)
    }
}





/*
1 2 3 4 5 6 7
24 25 26 27 28 29 8
23 40 41 42 43 30 9
22 39 48 49 44 31 10
21 38 47 46 45 32 11
20 37 36 35 34 33 12
19 18 17 16 15 14 13
*/