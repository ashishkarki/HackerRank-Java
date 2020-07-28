package com.karkia.algorithms.sorting.countingSort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// https://www.hackerrank.com/challenges/countingsort1/problem?h_r=next-challenge&h_v=zen
// Time Complexity: O(n+k) //n is the total numbers and k is total unique numbers
// Space Complexity: O(n) //we have to initialize an array equal to n
public class CountingSort1 {
    // Complete the countingSort function below.
    static int[] countingSort(int[] arr) {
        int[] frequencies = new int[100]; // as per problem statement
        for (int item : arr) {
            frequencies[item]++;
        }

        return frequencies;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrItems[i]);
        }

        int[] result = countingSort(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }

        scanner.close();
    }
}
