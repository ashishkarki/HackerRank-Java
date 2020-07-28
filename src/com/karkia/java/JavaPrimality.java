package com.karkia.java;

import java.math.BigInteger;
import java.util.Scanner;

class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BigInteger bigInteger = scanner.nextBigInteger();
        scanner.close();
        System.out.println(bigInteger.isProbablePrime(10) ? "prime" : "not prime");
    }
}
