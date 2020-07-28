package com.karkia.java;

import java.util.BitSet;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-bitset/problem
public class JavaBitset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        BitSet B1 = new BitSet(N);
        BitSet B2 = new BitSet(N);

        while (M-- > 0) {
            String operation = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            switch (operation) {
                case "AND":
                    if (a == 1) {
                        B1.and(B2);
                    } else {
                        B2.and(B1);
                    }
                    break;
                case "OR":
                    if (a == 1) {
                        B1.or(B2);
                    } else {
                        B2.or(B1);
                    }
                    break;
                case "XOR":
                    if (a == 1) {
                        B1.xor(B2);
                    } else {
                        B2.xor(B1);
                    }
                    break;
                case "FLIP":
                    if (a == 1) {
                        B1.flip(b);
                    } else {
                        B2.flip(b);
                    }
                    break;
                case "SET":
                    if (a == 1) {
                        B1.set(b);
                    } else {
                        B2.set(b);
                    }
                    break;
                default:
                    break;
            }

            System.out.println(B1.cardinality() + " " + B2.cardinality());
        }
    }
}
