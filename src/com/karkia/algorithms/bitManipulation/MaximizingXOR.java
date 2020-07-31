package com.karkia.algorithms.bitManipulation;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/maximizing-xor/problem
public class MaximizingXOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = Integer.parseInt(scanner.nextLine());
        int r = Integer.parseInt(scanner.nextLine());
        scanner.close();

        System.out.println(findMaxXor(l, r));
    }

    private static long findMaxXor(int l, int r) {
        int maxXorValue = 0;
        for (int i = l; i < r; i++) {
            int temp = i ^ (i + 1);
            if (temp > maxXorValue) {
                maxXorValue = temp;
            }
        }

        return maxXorValue;
    }
}
