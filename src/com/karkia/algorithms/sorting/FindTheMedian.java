package com.karkia.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheMedian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inputSize = input.nextInt();
        int[] inputArr = new int[inputSize];
        for (int i = 0; i < inputSize; i++) {
            inputArr[i] = input.nextInt();
        }

        Arrays.sort(inputArr);

        if (inputSize % 2 == 0) {
            System.out.println(inputArr[inputSize / 2]);
        } else {
            System.out.println((inputArr[inputSize / 2] + inputArr[inputSize / 2 + 1]) / 2);
        }
    }
}
