package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/linkedin-practice-caesar-cipher/problem
public class CaesarCipherEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int strLen = Integer.parseInt(scanner.nextLine());
        String inputStr = scanner.nextLine();
        int caesarShift = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder("");
        for (char ch : inputStr.toCharArray()) {
            if (Character.isLetter(ch)) {
                final char base = Character.isLowerCase(ch) ? 'a' : 'A';
//                System.out.println("ch: " + ch + ", base: " + base + ", calc1:" + (ch - base + caesarShift)
//                        + ", calc2: " + ((ch - base + caesarShift) % 26 + base));
                sb.append((char) ((ch - base + caesarShift) % 26 + base));
            } else {
                sb.append(ch);
            }
        }

        System.out.println(sb.toString());
    }
}
