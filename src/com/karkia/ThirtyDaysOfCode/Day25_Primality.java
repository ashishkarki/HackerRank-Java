package com.karkia.ThirtyDaysOfCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day25_Primality {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<Integer> inputs = new ArrayList<Integer>();

        while (T-- > 0) {
            inputs.add(sc.nextInt());
        }

        sc.close();

        inputs.forEach(input -> {
            if (primeChecker(input)) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        });
    }

    private static boolean primeChecker(Integer n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
