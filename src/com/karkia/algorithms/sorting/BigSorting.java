package com.karkia.algorithms.sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/big-sorting/problem
// Space Complexity: O(1) // we reuse the unsorted array
// Time Complexity: O(n) //We dynamically allocate an array to store the input
public class BigSorting {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int numOfIntegerStrs = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[numOfIntegerStrs];
        for (int i = 0; i < numOfIntegerStrs; i++) {
            unsorted[i] = scanner.next();
        }

        scanner.close();

        Arrays.sort(unsorted, (s1, s2) -> compareStringAsInteger(s1, s2));

        StringBuilder result = new StringBuilder("");
        for (String sortedNum : unsorted) {
            result.append(sortedNum + "\n");
        }
        System.out.println(result);
    }

    // result = 0 when s1 = s2, 1 when s1 > s2 and -1 when s1 < s2
    private static int compareStringAsInteger(String s1, String s2) {
        if (s1.length() > s2.length()) return 1;
        if (s1.length() < s2.length()) return -1;

        // if both are equal length, compare each corresponding character
        for (int i = 0; i < s1.length(); i++) {
            if ((int) s1.charAt(i) > (int) s2.charAt(i)) return 1;
            if ((int) s1.charAt(i) < (int) s2.charAt(i)) return -1;
        }

        // everything is same
        return 0;
    }
}
