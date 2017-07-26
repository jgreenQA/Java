package com.qac.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Advanced {
    public static void main(String[] args) throws Exception {
        //Timer t = new Timer();

        Timer.startTimer();
        //System.out.print(getPrimesAmount(1000000, 3000000)); Timer.endTimer();
        //System.out.println(" - Took " + Timer.getElapsedTime() + "ms");

        Timer.startTimer();
        //System.out.print(getPrimesAmount(0, 200000000)); Timer.endTimer();
        //System.out.println(" - Took " + Timer.getElapsedTime() + "ms");

        System.out.println(commonSubstring("salad", "ladder"));

        //System.out.println(Arrays.toString(findAnagrams("test.txt").toArray()));
    }

    private static ArrayList<String> findAnagrams(String filename) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        HashMap<String, ArrayList<String>> h = new HashMap<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();

        String s;
        while ((s = in.readLine()) != null) {
            words.add(s);
    }

        String orig;
        char[] outerSorted, innerSorted;
        for (String outerWord : words) {
            orig = outerWord;
            Arrays.sort(outerSorted = outerWord.toLowerCase().toCharArray());

            for (String innerWord : words) {
                Arrays.sort(innerSorted = innerWord.toLowerCase().toCharArray());

                if (Arrays.equals(outerSorted, innerSorted)) {
                    a.add(innerWord);
                }
            }
            h.put(orig, a);
            a = new ArrayList<>();
        }

        int max = 0;
        ArrayList<String> keys = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : h.entrySet()) {
            if (entry.getValue().size() > max) {
                keys.clear();
                keys.add(entry.getKey());
                max += entry.getValue().size();
            } else if (entry.getValue().size() == max - 1) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    private static String commonSubstring(String x, String y) {
        int m = x.length(), n = y.length();
        int max = 0, pos = 0, i, j;

        int[][] a = new int[m][n];

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (x.charAt(i) == y.charAt(j)) {
                    if (i == 0 || j == 0) {
                        a[i][j] = 1;

                    } else {
                        a[i][j] = a[i - 1][j - 1] + 1;
                    }

                    if (max < a[i][j]) {
                        max = a[i][j];
                        pos = i + 1;
                    }
                }
            }
        }
        if (pos > 0) {
            return x.substring(pos - max, pos);
        }
        return "";
    }

    private static int getPrimesAmount(int lower, int upper) {
        int primesAmount = 0;

        if (lower < 2) {
            lower = 2;
        }

        for (int i = lower; i < upper; i++) {
            if (isPrime(i)) {
                primesAmount++;
            }
        }
        return primesAmount;
    }

    private static boolean isPrime(int n) {
        if (n % 2 == 0) {
            return n == 2;
        } else if (n % 3 == 0) {
            return n == 3;
        }

        int step = 4, m = (int)Math.sqrt(n) + 1;
        for (int i = 5; i < m; step = 6 - step, i += step) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class Timer {
    private static long startTime;
    private static long endTime;

    public static void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public static void endTimer() {
        endTime = System.currentTimeMillis();
    }

    public static long getElapsedTime() {
        return endTime - startTime;
    }
}
