package com.karkia.ThirtyDaysOfCode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Day29_BitwiseAnd {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Map<Integer, Integer> nkMap = new LinkedHashMap<>();
        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");
            int N = Integer.parseInt(nk[0]);
            int K = Integer.parseInt(nk[1]);

            nkMap.put(N, K);

            bitWiser(nkMap);
        }

        scanner.close();
    }

    private static void bitWiser(Map<Integer, Integer> nkMap) {
        nkMap.entrySet().forEach(entry -> {
//            final Integer N = entry.getKey();
//            final Integer K = entry.getValue();
//
//            if (((K - 1) | K) <= N) {
//                System.out.println(K - 1);
//            } else {
//                System.out.println(K - 2);
//            }

            int max = Integer.MIN_VALUE;
            final Integer N = entry.getKey();
            final Integer K = entry.getValue();

            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    final int bitwise = i & j;
                    if (bitwise < K && bitwise > max) {
                        max = bitwise;
                    }
                }
            }

            System.out.println(max);
        });
    }
}

