package com.karkia.algorithms.quicksort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quicksort1_Partition {
    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) {
        final int pivot = arr[0];
        final List<Integer> left = new ArrayList<>();
        final List<Integer> right = new ArrayList<>();

        for (int item : arr) {
            if (item < pivot) {
                left.add(item);
            } else if (item > pivot) {
                right.add(item);
            }
        }

        left.add(pivot);
        left.addAll(right);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = left.get(i);
        }

        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = quickSort(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}