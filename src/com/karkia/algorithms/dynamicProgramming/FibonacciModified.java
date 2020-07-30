package com.karkia.algorithms.dynamicProgramming;

import java.math.BigDecimal;
import java.util.Scanner;

public class FibonacciModified {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal t1 = new BigDecimal(scanner.nextInt());
        BigDecimal t2 = new BigDecimal(scanner.nextInt());
        int nthNumToReturn = scanner.nextInt();
        scanner.close();

        if (nthNumToReturn == 0) {
            System.out.println(0);
            System.exit(1);
        }
        if (nthNumToReturn == 1 || nthNumToReturn == 2) {
            System.out.println(1);
            System.exit(1);
        }

        BigDecimal result = new BigDecimal(0);
        for (int i = 3; i <= nthNumToReturn; i++) {
            result = t1.add(t2.multiply(t2));
            t1 = t2;
            t2 = result;
        }

        System.out.println(result);
    }

}
