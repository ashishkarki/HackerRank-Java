package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/mars-exploration/problem
// time complexity: O(n), space complexity: O(1)
public class MarsExploration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String receivedSignal = scanner.nextLine();

        int difference = 0;
        final String sos = "SOS";
        for (int i = 0; i < receivedSignal.length(); i++) {
            if (receivedSignal.charAt(i) != sos.charAt(i % 3)) {
                difference++;
            }
        }

        System.out.println(difference);
    }
}
