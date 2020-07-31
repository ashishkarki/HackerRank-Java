package com.karkia.dataStructures.array;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/crush/problem
// time: O(m (to manipulate) + n (to print)) time using prefix sum algorithms
public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numElements = scanner.nextInt();
        int numQueries = scanner.nextInt();
        int queries[][] = new int[numQueries][3];

        for (int i = 0; i < numQueries; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
            queries[i][2] = scanner.nextInt();
        }
        scanner.close();

        final long max = arrayManipulator(numElements, queries);
        System.out.println(max);
    }

    private static long arrayManipulator(int numElements, int[][] queries) {
        // since input-array is 1-based, we make this numEle+1 to avoid complexity
        long[] resultArr = new long[numElements + 1];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            resultArr[a] += k;

            if (b + 1 < resultArr.length) {
                resultArr[b + 1] -= k;
            }
        }

        resultArr = performPrefixSum(resultArr);

        return Arrays.stream(resultArr).max().getAsLong();
    }

    private static long[] performPrefixSum(long[] arr) {
        long[] prefixSum = new long[arr.length];

        prefixSum[0] = arr[0];

        // adding present element with previous element
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        return prefixSum;
    }
}
