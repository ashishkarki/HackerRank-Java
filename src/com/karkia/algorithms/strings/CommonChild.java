package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/common-child/problem
// Print the length of the longest string s, such that s is a child of both s1 and s2.
public class CommonChild {
    // Method2- recursive solution with memoization
    // time complexity - O(m*n)
    // space complexity - O(m*n)
    public static int LCSM2(char[] X, char[] Y, int rows, int cols, Integer[][] cache) {
        //base case
        if (rows <= 0 || cols <= 0) {
            return 0;
        }
        // other cases
        else if (X[rows - 1] == Y[cols - 1]) {
            return 1 + LCSM2(X, Y, rows - 1, cols - 1, cache);
        } else {
            cache[rows][cols] = Math.max(
                    LCSM2(X, Y, rows, cols - 1, cache),
                    LCSM2(X, Y, rows - 1, cols, cache)
            );
            return cache[rows][cols];
        }
    }

    // Method4- DP solution(Bottom up approach)
    // time complexity - O(m*n)
    // space complexity - O(n)
    public static int LCSM4(char[] X, char[] Y, int rows, int cols) {
        int cache[] = new int[cols + 1];

        for (int i = 1; i <= rows; i++) {
            int prev = 0;
            for (int j = 1; j <= cols; j++) {
                int temp = cache[j];
                if (X[i - 1] == Y[j - 1]) {
                    cache[j] = prev + 1;
                } else {
                    cache[j] = Math.max(cache[j], cache[j - 1]);
                }
                prev = temp;
            }
        }

        return cache[cols];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String X = scanner.nextLine();
        final String Y = scanner.nextLine();
        scanner.close();

//        System.out.println(LCSM2(
//                X.toCharArray(),
//                Y.toCharArray(),
//                X.length(),
//                Y.length(),
//                new Integer[X.length() + 1][Y.length() + 1]
//        ));

        System.out.println(
                LCSM4(
                        X.toCharArray(),
                        Y.toCharArray(),
                        X.length(),
                        Y.length()
                )
        );
    }
}
