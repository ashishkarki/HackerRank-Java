package com.karkia.dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/sparse-arrays/problem
public class SparseArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStrings = scanner.nextInt();
        scanner.nextLine();

        // save input strings freq
        Map<String, Integer> inputToFreqMap = new HashMap<>();
        for (int i = 0; i < numStrings; i++) {
            final String inputStr = scanner.nextLine();
            inputToFreqMap.merge(inputStr, 1, Integer::sum);
        }

        // queries
        int numQueries = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numQueries; i++) {
            final String queryStr = scanner.nextLine();
            System.out.println(inputToFreqMap.getOrDefault(queryStr, 0));
        }
    }
}
