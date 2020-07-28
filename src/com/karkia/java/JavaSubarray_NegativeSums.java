package com.karkia.java;

import java.util.Arrays;
import java.util.Scanner;

public class JavaSubarray_NegativeSums {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.println(countNegativeSubarrays(arr));
    }

    private static int countNegativeSubarrays(int[] arr) {
        int negativeSubarrayCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum < 0) {
                    negativeSubarrayCount++;
                }
            }
        }


        return negativeSubarrayCount;
    }
}
