package com.karkia.algorithms.dynamicProgramming;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/maxsubarray/problem
// time: O(n) by using Kidane's algorithms below
public class MaximumSubArray {
    /*
    We define subsequence as any subset of an array.
    We define a subarray as a contiguous subsequence in an array.
     */
    private static int[] maxSubarrayFinder(int[] elements) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingAtThisElement = 0;
        int maxSum = 0;

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] > 0) {
                maxSum += elements[i];
            }
            // max-sum-ending at this element is either this element or sum of elements before it
            maxEndingAtThisElement += elements[i];
            maxEndingAtThisElement = Math.max(maxEndingAtThisElement, elements[i]);

            maxSoFar = Math.max(maxSoFar, maxEndingAtThisElement);
        }

        final int subArrayContiguousSum = maxSoFar;
        final int subsequenceNonContiguousSum = maxSoFar < 0 ?
                maxSoFar :
                maxSum;
        return new int[]{
                subArrayContiguousSum, subsequenceNonContiguousSum
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();

        while (numTests-- > 0) {
            int numElements = scanner.nextInt();
            int[] elements = new int[numElements];
            for (int i = 0; i < numElements; i++) {
                elements[i] = scanner.nextInt();
            }

            // perform logic to find subarray and subsequence
            int[] result = maxSubarrayFinder(elements);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");
        }

        scanner.close();
    }
}
