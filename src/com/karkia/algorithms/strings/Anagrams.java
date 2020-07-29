package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/anagram/problem
public class Anagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numQueries; i++) {
            final String s = scanner.nextLine();
            System.out.println(checkAnagram(s));
        }

        scanner.close();
    }

    static int checkAnagram(String query) {
        if ((query.length() & 1) == 1) {
            return -1;
        }

        int minChanges = 0;
        final int englishLetterCount = 26;
        int[] charFreq = new int[englishLetterCount];
        final int baseCharValue = 'a';
        final int qLen = query.length();
        for (int i = 0; i < qLen; i++) {
            int charValue = query.charAt(i) - baseCharValue;
            // is this char on left or right side
            if (i < qLen / 2) { // left half
                charFreq[charValue]++;
            } else { // right half
                charFreq[charValue]--;
            }
        }

        for (int i = 0; i < englishLetterCount; i++) {
            if (charFreq[i] > 0) {
                minChanges += charFreq[i];
            }
        }

        return minChanges;
    }
}
