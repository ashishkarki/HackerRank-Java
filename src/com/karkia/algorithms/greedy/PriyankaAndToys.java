package com.karkia.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/priyanka-and-toys/problem
// Time Complexity: O(n log(n)) //We have to sort the toys by weight
//Space Complexity: O(n) //We store the input in a dynamically allocated array
public class PriyankaAndToys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOrdersToShip = scanner.nextInt();

        int[] toyWeights = new int[numOrdersToShip];
        for (int i = 0; i < numOrdersToShip; i++) {
            toyWeights[i] = scanner.nextInt();
        }

        // sort the toy orders by ascending
        Arrays.sort(toyWeights);

        // iterate over it not counting when we get the next 4
        // consecutive weight toys for free
        int totalContainers = 1;
        int minWtInCurrentContainer = toyWeights[0];
        for (int weight : toyWeights) {
            if (!(weight <= minWtInCurrentContainer + 4)) {
                totalContainers++;
                minWtInCurrentContainer = weight;
            }
        }

        System.out.println(totalContainers);
    }
}
