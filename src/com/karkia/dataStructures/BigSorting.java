package com.karkia.dataStructures;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/big-sorting/problem
public class BigSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numIntegers = scanner.nextInt();
        scanner.nextLine();

        BigInteger[] unsorted = new BigInteger[numIntegers];
        for (int i = 0; i < numIntegers; i++) {
            unsorted[i] = scanner.nextBigInteger();
        }
        scanner.close();

        Arrays.sort(unsorted, Comparator.naturalOrder());

        for (BigInteger bI : unsorted) {
            System.out.println(bI);
        }
    }
}
