package com.karkia.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/challenges/pangrams/problem
// Time complexity: O(n)
// Space complexity: O(1)
public class Pangram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine()
                .toLowerCase()
                .replaceAll("\\s", "");
        scanner.close();

        Set<Character> alphabets = new HashSet<>();
        for (int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);
            if (Character.isLetter(ch)) {
                alphabets.add(ch);
            }
        }

        if (alphabets.size() == 26) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }
}
