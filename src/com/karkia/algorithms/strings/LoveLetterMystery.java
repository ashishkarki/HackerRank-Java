package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/the-love-letter-mystery/problem
// Time complexity: O(n)
// Space complexity: O(1)
public class LoveLetterMystery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numQueries; i++) {
            String input = scanner.nextLine();
            int totalOperations = 0; // to convert this string to palindrome

            // keep two pointers at each end. At each iteration,
            // find out which item is greater and reduce that by their difference
            // Also, add that difference to total-operations
            int startPointer = 0;
            int endPointer = input.length() - 1;
            while (startPointer < endPointer) {
                totalOperations += Math.abs(input.charAt(startPointer) - input.charAt(endPointer));
                startPointer++; // move start pointer to right
                endPointer--; // move end pointer to left
            }

            System.out.println(totalOperations);
        }
    }
}
