package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/camelcase/problem
// time complexity: O(n), space complexity: O(1)
public class CamelCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        int wordCount = 1;
        for (int i = 0; i < inputStr.length(); i++) {
            final char ch = inputStr.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }
}
