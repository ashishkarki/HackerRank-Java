package com.karkia.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/mark-and-toys/problem
// Time Complexity: O(n log(n)) //It takes n log n time to run quicksort on the input array
// Space Complexity: O(n) //We dynamically allocate and array to store the input
public class MarkAndToys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numToys = scanner.nextInt();
        int budget = scanner.nextInt();

        int[] prices = new int[numToys];
        for (int i = 0; i < numToys; i++) {
            prices[i] = scanner.nextInt();
        }

        // sort the prices in asc order
        Arrays.sort(prices);

        int runningSum = 0;
        int toysCanBuy = 0; // total toys that Mark can buy
        for (int toyPrice : prices) {
            runningSum += toyPrice;
            if (runningSum >= budget) {
                break;
            } else {
                toysCanBuy++;
            }
        }

        System.out.println(toysCanBuy);
    }
}
