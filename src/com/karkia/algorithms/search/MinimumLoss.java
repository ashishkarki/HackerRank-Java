package com.karkia.algorithms.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/minimum-loss/problem
// Time Complexity: O(n log(n)) //We must sort the input array
//Space Complexity: O(n) //We use a map to store the price,year pairs
public class MinimumLoss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numYearsOfHouseData = scanner.nextInt();

        long[] housePrices = new long[numYearsOfHouseData];
        Map<Long, Integer> priceYearMap = new HashMap<>();
        for (int i = 0; i < numYearsOfHouseData; i++) {
            housePrices[i] = scanner.nextLong();
            priceYearMap.put(housePrices[i], i);
        }

        Arrays.sort(housePrices);

        Long minLoss = Long.MAX_VALUE;

        // to ensure, we sell after we buy, go from end to start
        for (int i = numYearsOfHouseData - 1; i > 0; i--) {
            // if this is a new min
            if (minLoss > (housePrices[i] - housePrices[i - 1])) {
                // verify sell year comes after buy year
                if (priceYearMap.get(housePrices[i]) < priceYearMap.get(housePrices[i - 1])) {
                    minLoss = housePrices[i] - housePrices[i - 1];
                }
            }
        }

        System.out.println(minLoss);
    }
}
