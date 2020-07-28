package com.karkia.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/closest-numbers/problem
// Time Complexity: O(n log(n)) //We need to sort the array list
// Space Complexity: O(n) //We use a dynamically sized StringBuilder
public class ClosestNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputSize = scanner.nextInt();

        int[] inputArr = new int[inputSize];
        for (int i = 0; i < inputSize; i++) {
            inputArr[i] = scanner.nextInt();
        }

        // sort the array
        Arrays.sort(inputArr);

        int minAbsDiff = Integer.MAX_VALUE;
        StringBuilder pairs = new StringBuilder(""); // store min. pairs

        for (int i = 0; i < inputSize - 1; i++) {
            final int curAbsDiff = Math.abs(inputArr[i] - inputArr[i + 1]);

            if (minAbsDiff > curAbsDiff) {
                minAbsDiff = curAbsDiff;
                // also discard old pairs and create new ones
                pairs = new StringBuilder("");
                // add this min pair
                pairs.append(inputArr[i] + " " + inputArr[i + 1] + " ");
            } else if (minAbsDiff == curAbsDiff) {
                // if there are more than one min pairs, add them all
                pairs.append(inputArr[i] + " " + inputArr[i + 1] + " ");
            }
        }

        System.out.println(pairs.toString());
    }
}
