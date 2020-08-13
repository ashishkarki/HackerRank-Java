package com.karkia.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/challenges/java-hashset/problem
public class JavaHashset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        String[] pair_left = new String[T];
        String[] pair_right = new String[T];

        for (int i = 0; i < T; i++) {
            pair_left[i] = scanner.next();
            pair_right[i] = scanner.next();
        }

        scanner.close();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < T; i++) {
            set.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(set.size());
        }
    }
}
