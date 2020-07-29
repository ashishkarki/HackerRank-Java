package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/caesar-cipher-1/problem
// time and space complexity: O(n)
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputStrLen = scanner.nextInt();
        scanner.nextLine();
        String inputStr = scanner.nextLine();
        int numLetterToRotate = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputStrLen; i++) {
            final char ch = inputStr.charAt(i);
            sb.append(encrypt(ch, numLetterToRotate));
        }

        System.out.println(sb.toString());
    }

    private static char encrypt(char ch, int numLetterToRotate) {
        if (!Character.isLetter(ch)) {
            return ch;
        }

        char base = Character.isLowerCase(ch) ? 'a' : 'A';
        return (char) ((ch - base + numLetterToRotate) % 26 + base);
    }
}
