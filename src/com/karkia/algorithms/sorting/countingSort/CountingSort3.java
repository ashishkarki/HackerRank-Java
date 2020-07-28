package com.karkia.algorithms.sorting.countingSort;

import java.util.Scanner;

public class CountingSort3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numInputs = scanner.nextInt();
        int[] frequencies = new int[100];

        for (int i = 0; i < numInputs; i++) {
            final int inputNum = scanner.nextInt();
            scanner.next(); // ignore the string coming next
            frequencies[inputNum]++;
        }
        scanner.close();

        // print "L" for each frequency bucket
        int count = 0;
        for (int i = 0; i < frequencies.length; i++) {
            count += frequencies[i]; // keep adding to count as we go up the freq. array
            System.out.print(count + " ");
        }
    }
}
