package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/game-of-thrones/problem
// time: O(n) - time increases with increase in inputStr size
// space: O(1) - we need an array of 26 no matter string size
public class GameOfThrones_I {
    final static int ENGLISH_LETTERS_COUNT = 26;

    static String gameOfThrones(String s) {
        // MAIN IDEA: is that a palindrome is a word in which there is
        // Only One Character that is Odd. so if there are more than one odd
        // characters than, it is not a palindrome
        int[] freqArr = new int[ENGLISH_LETTERS_COUNT];
        for (int i = 0; i < s.length(); i++) {
            final int index = s.charAt(i) - 'a'; // get ASCII value
            freqArr[index]++;
        }

        int oddCharCount = 0; // this cannot be greater than 1
        for (int i = 0; i < ENGLISH_LETTERS_COUNT; i++) {
            if (freqArr[i] != 0 && (freqArr[i] & 1) == 1) {
                oddCharCount++;
            }
        }

        return oddCharCount > 1 ? "NO" : "YES";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        scanner.close();
        System.out.println(gameOfThrones(inputStr));
    }
}
