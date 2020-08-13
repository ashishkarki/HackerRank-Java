package com.karkia.algorithms.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
public class MinimumAbsoluteDifference {
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i - 1]));
        }

        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();
        System.out.println(minimumAbsoluteDifference(array));
    }
}