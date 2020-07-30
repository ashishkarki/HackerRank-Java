package com.karkia.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/challenges/string-construction/problem
/*
IDEA: Note there is no cost for copying a substring but $1 cost per
character we have to copy from source to destination string. Calculating
a minimum cost means that we have to find how many unique chars. in
the source string does the destination string need.
 */
// time: O(n), space: O(n)
public class StringConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numQueries; i++) {
            String inputStr = scanner.nextLine();
            Set<Character> uniqueCharsInSrc = new HashSet<>();
            for (char c : inputStr.toCharArray()) {
                uniqueCharsInSrc.add(c);
            }

            System.out.println(uniqueCharsInSrc.size());
        }
    }
}
