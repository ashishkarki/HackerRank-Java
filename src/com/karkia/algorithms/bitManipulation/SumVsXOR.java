package com.karkia.algorithms.bitManipulation;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/sum-vs-xor/problem
/*
Given an integer n, find each x such that:
=> 0 <= x <= n
=> n + x = n ^ x
 */
public class SumVsXOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();

        sumXorer(n);
    }

    static void sumXorer(long n) {
        final int zerosInN = countZeros(n);
        System.out.println((long) Math.pow(2, zerosInN));
    }

    private static int countZeros(long n) {
        int zeroCount = 0;
        while (n > 0) {
            zeroCount += (n % 2 == 0) ? 1 : 0;
            n /= 2;
        }

        return zeroCount;
    }
}

/*
THEORY OF ABOVE SOLUTION: SRC - https://github.com/RodneyShag/HackerRank_solutions/blob/master/Algorithms/Bit%20Manipulation/Sum%20vs%20XOR/Solution.java
// XOR represents binary addition without the "carry" for each digit. We want to see
// how many values of x that will give us n+x = n^x, which is when XOR is the same as
// ADDITION. This happens when there are no "carries". To make sure there are no
// carries, for each digit in "n" that is a 1, we must have the corresponding digit in
// "x" be a 0. For each digit in "n" that is a 0, we can have the corresponding digit
// in "x" be either 0 or 1. Now we calculate the number of possibilities for "x" by
// counting the number of 0s in "n" (up to the most significant 1 in n), and doing
// 2^(number of 0s) (where ^ is exponentiation in this case) to count all combinations
 */
