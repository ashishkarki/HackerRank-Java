package com.karkia.algorithms.recursion;

import java.math.BigInteger;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/recursive-digit-sum/problem
public class RecursiveDigitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nk = scanner.nextLine().split(" ");
        String p = "";
        for (int i = 0; i < Integer.parseInt(nk[1]); i++) {
            p += nk[0];
        }

        //System.out.println(findSuperDigit(p));
        System.out.println(findSuperDigitUsingMathTrick(nk));
    }

    static int findSuperDigitUsingMathTrick(String[] nk) {
        BigInteger n1 = new BigInteger(nk[0]);
        n1 = n1.multiply(new BigInteger(nk[1] + ""));
        n1 = n1.remainder(new BigInteger("9"));

        final int n1IntValue = n1.intValue();
        return n1IntValue == 0 ? 9 : n1IntValue;
    }

//    static String findSuperDigit(String digitStr) {
//        if (digitStr.length() == 1) {
//            return digitStr;
//        }
//
//        long sum = 0;
//        for (char ch : digitStr.toCharArray()) {
//            sum += Integer.parseInt(String.valueOf(ch));
//        }
//        digitStr = Long.toString(sum);
//
//        return findSuperDigit(digitStr);
//    }
}
