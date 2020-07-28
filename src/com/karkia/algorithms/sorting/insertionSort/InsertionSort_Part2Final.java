package com.karkia.algorithms.sorting.insertionSort;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/insertionsort2/problem?h_r=next-challenge&h_v=zen
//Time Complexity: O(n^2)
//Space Complexity: O(1)
public class InsertionSort_Part2Final {
    static void insertionSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    // swap and bring them to right places for now
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else {

                    // since, we are sorting ascending,
                    // j-1 and j are in the right spot for now
                    break;
                }
            }
            printArray(arr);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrItems[i]);
        }

        scanner.close();
        insertionSort2(arr);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
