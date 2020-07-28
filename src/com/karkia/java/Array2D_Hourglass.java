package com.karkia.java;

import java.util.Scanner;

public class Array2D_Hourglass {

    private static final Scanner scanner = new Scanner(System.in);

    public static void hourglass(int[][] a) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length - 2; i++) {
            for (int j = 0; j < a.length - 2; j++) {
                final int hourglassSum = a[i][j] + a[i][j + 1] + a[i][j + 2]
                        + a[i + 1][j + 1]
                        + a[i + 2][j] + a[i + 2][j + 1] + a[i + 2][j + 2];
                if(hourglassSum > max) {
                    max = hourglassSum;
                }
            }
        }

        System.out.println(max);
    }

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

        hourglass(arr);

        scanner.close();
    }
}
