package com.karkia.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/sherlock-and-array/problem
public class SherlockAndArray {
    static String balanceChecker(int[] elements) {
        if (elements.length == 1) {
            return "YES";
        } else if (elements.length == 2) {
            return "NO";
        }

        // assume there is an element y which divides the array into two equal halves
        // of sum 'x' each. so that total sum = 2x + y => 2x = sum - y

        // step 1: calculate the total 'sum' of array
        final int sum = Arrays.stream(elements).sum();

        // step 2: loop through each element and check if there is an element 'y'
        int x = 0; // initially, we start y at leftmost side, so x = 0
        for (int y : elements) {
            if (2 * x == sum - y) {
                return "YES";
            }
            x += y; // as y moves to the right, x gets y's values
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int i = 0; i < numTestCases; i++) {
            int numElements = scanner.nextInt();
            int[] elements = new int[numElements];

            for (int j = 0; j < numElements; j++) {
                elements[j] = scanner.nextInt();
            }

            String result = balanceChecker(elements);
            System.out.println(result);
        }

        scanner.close();
    }
}
