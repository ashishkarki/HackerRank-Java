package com.karkia.algorithms.sorting.countingSort;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/countingsort2/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
// Time Complexity: O(n+k) //n is the total numbers and k is total unique numbers
// Space Complexity: O(n) //we have to initialize an array equal to n
public class CountingSort2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numInputs = scanner.nextInt();
        int[] frequencies = new int[100];

        for (int i = 0; i < numInputs; i++) {
            final int inputNum = scanner.nextInt();
            frequencies[inputNum]++;
        }
        scanner.close();

        // print in order of frequencies
        for (int i = 0; i < frequencies.length; i++) {
            for (int j = 0; j < frequencies[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
