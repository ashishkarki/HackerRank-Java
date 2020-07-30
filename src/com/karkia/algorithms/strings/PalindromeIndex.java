package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/palindrome-index/problem
public class PalindromeIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = Integer.parseInt(scanner.nextLine());

        while (numQueries-- > 0) {
            System.out.println(findPalindromeIndex(scanner.nextLine()));
        }

        scanner.close();
    }

    static int findPalindromeIndex(String s) {
        int sLen = s.length();

        for (int i = 0; i < sLen / 2; i++) {
            // start by comparing at both ends of the string
            if (s.charAt(i) != s.charAt(sLen - i - 1)) {
                // find the point at which left char != right char and the palindrome nature is lost
                if (i + 1 < sLen) {
                    // Next, find which part left or right is the culprit in making non-palindrome
                    boolean isRightHalfValidPalindrome = isPalindrome(s.substring(i + 1, sLen - i));
                    if (isRightHalfValidPalindrome) {
                        // throw character from left side since the remaining part of right is palindrome
                        return i;
                    }
                    // otherwise, throw character from right side
                    return sLen - 1 - i;
                }
            }
        }

        return -1;
    }

    static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
}
