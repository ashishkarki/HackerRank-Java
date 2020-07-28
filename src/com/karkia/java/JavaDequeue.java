package com.karkia.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/challenges/java-dequeue/problem
public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        final int subarraySize = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int maxUnique = Integer.MIN_VALUE;
        for (int i = 0; i < (n - subarraySize); i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < (i + subarraySize); j++) {
                set.add(arr[j]);
            }

            if (set.size() > maxUnique) {
                maxUnique = set.size();
            }
        }

        System.out.println(maxUnique);
    }
}
