package com.karkia.algorithms.sorting.insertionSort;

import java.util.Scanner;

// Using Insertion sort
public class RunningTimeOfAlgos {
    static void shiftCounter(int[] arr) {
        int totalShifts = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    // the item on the right is smaller, so move it into left side
                    final int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                    totalShifts++;
                } else {
                    // since the leftmost element on the left side is already greater than
                    // the right element i.e. arr[j], NO further comparison needed
                    break;
                }
            }
        }

        System.out.println(totalShifts);
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
        shiftCounter(arr);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
