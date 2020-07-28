package com.karkia.ThirtyDaysOfCode;

import java.util.Scanner;

public class Day11_2DArrays {

    public static void solver(int[][] a) {
        int sum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; i++) {
                if ((i + 2) < 6 && (j + 2) < 6) {
                    sum = a[i][j] +
                            a[i][j + 1] +
                            a[i][j + 2] +
                            a[i + 1][j + 1] +
                            a[i + 2][j] +
                            a[i + 2][j + 1] +
                            a[i + 2][j + 2];
                }

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();
    }
}

