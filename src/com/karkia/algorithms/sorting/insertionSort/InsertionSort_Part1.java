package com.karkia.algorithms.sorting.insertionSort;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/insertionsort1/problem
//Time Complexity: O(n)
//Space Complexity: O(1)
public class InsertionSort_Part1 {
    // Complete the insertionSort1 function below.
    static void insertionSort1(int[] arr) {
        int elemToBeInserted = arr[arr.length - 1]; // number to be inserted
        for (int i = arr.length - 2; i >= 0; i--) {
            // arr.len - 1 is normal, arr.len - 2 since last number is elemToBeInserted
            if (elemToBeInserted >= arr[i]) { // this location is where it goes
                arr[i + 1] = elemToBeInserted;
                printArray(arr);
                break;
            }

            arr[i + 1] = arr[i]; // copy/shift this item to the right side
            printArray(arr);
        }

        // edge-case: if elemToBeInserted is the smallest
        if (elemToBeInserted < arr[0]) {
            arr[0] = elemToBeInserted;
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
        insertionSort1(arr);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
