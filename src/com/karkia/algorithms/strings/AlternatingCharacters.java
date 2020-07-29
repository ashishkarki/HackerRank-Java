package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/alternating-characters/problem
public class AlternatingCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        scanner.nextLine(); // move from the line with queries int into new line

        while (numQueries-- > 0) {
            final String inputStr = scanner.nextLine();
            int totalDeletions = 0;

            for (int i = 1; i < inputStr.length(); i++) {
                if (inputStr.charAt(i - 1) == inputStr.charAt(i)) {
                    totalDeletions++;
                }
            }
            System.out.println(totalDeletions);
        }
        scanner.close();
    }
}
