package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
public class StringsMakingAnagrams {
    final static int ENGLISH_LETTERS_COUNT = 26;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String s1 = scanner.nextLine();
        final String s2 = scanner.nextLine();
        scanner.close();

        int[] s1Array = createFreqArray(s1);
        int[] s2Array = createFreqArray(s2);

        int deletions = 0;
        for (int i = 0; i < ENGLISH_LETTERS_COUNT; i++) {
            deletions += Math.abs(s1Array[i] - s2Array[i]);
        }

        System.out.println(deletions);
    }

    static int[] createFreqArray(String s) {
        int[] freqArr = new int[ENGLISH_LETTERS_COUNT];
        for (int i = 0; i < s.length(); i++) {
            final char curChar = s.charAt(i);
            freqArr[curChar - 'a']++;
        }

        return freqArr;
    }
}
