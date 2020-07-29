package com.karkia.algorithms.bitManipulation;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/lonely-integer/problem
// Time Complexity: O(n) //We must check every element
// Space Complexity: O(1) //We use xor so everything is in place
public class LonelyInteger {
    // XOR: logical operation that outputs true only when inputs differ.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numIntegers = scanner.nextInt();

        int uniqueInteger = 0;
        for (int i = 0; i < numIntegers; i++) {
            uniqueInteger ^= scanner.nextInt();
        }

        System.out.println(uniqueInteger);
    }
}
