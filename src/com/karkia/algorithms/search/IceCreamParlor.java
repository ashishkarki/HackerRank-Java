package com.karkia.algorithms.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/icecream-parlor/problem
// Time complexity: O(n)    //The number of flavors we have to look at
// Space complexity: O(n)   //The number of flavors we store the complement of
public class IceCreamParlor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTrips = scanner.nextInt();
        for (int i = 0; i < numTrips; i++) {
            int amountPooled = scanner.nextInt();
            int numFlavors = scanner.nextInt();

            // map = <costOfEachFlavor, 1-based index of flavor>
            Map<Integer, Integer> complements = new HashMap<>();

            for (int j = 1; i <= numFlavors; j++) {
                int costOfEachFlavor = scanner.nextInt();
                if (complements.containsKey(costOfEachFlavor)) {
                    System.out.println(complements.get(costOfEachFlavor) + " " + j);
                } else {
                    complements.put(amountPooled - costOfEachFlavor, j);
                }
            }
        }
    }
}
