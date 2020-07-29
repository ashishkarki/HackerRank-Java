package com.karkia.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/challenges/two-strings/problem
//Time complexity: O(|a| + |b|)    //We iterate through each input string
//Space complexity: O(1) //Our sets can be at most 2 x character set in size
public class TwoStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        scanner.nextLine();

        while (numQueries-- > 0) {
            final String s1 = scanner.nextLine();
            final String s2 = scanner.nextLine();
            Set<Character> s1CharSet = new HashSet<>();
            Set<Character> s2CharSet = new HashSet<>();

            for (char ch : s1.toCharArray()) {
                s1CharSet.add(ch);
            }
            for (char ch : s2.toCharArray()) {
                s2CharSet.add(ch);
            }

            // find intersection
            s1CharSet.retainAll(s2CharSet);
            //System.out.println("size::" + s1CharSet.size());
            if (s1CharSet.size() > 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
