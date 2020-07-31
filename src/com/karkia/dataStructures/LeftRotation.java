package com.karkia.dataStructures;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/array-left-rotation/problem
public class LeftRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numIntegers = scanner.nextInt();
        int numLeftRotations = scanner.nextInt();
        scanner.nextLine();

        int[] nums = new int[numIntegers];
        for (int i = 0; i < numIntegers; i++) {
            nums[i] = scanner.nextInt();
        }

        scanner.close();

        int[] result = leftRotator(numIntegers, nums, numLeftRotations);
        for (int r : result) {
            System.out.print(r+" ");
        }
    }

    private static int[] leftRotator(int n, int[] arr, int rotations) {
        int[] rotatedArr = new int[n];

        for (int oldIdx = 0; oldIdx < n; oldIdx++) {
            // every element eventually gets moved one-place to its right
            int newIdx = (oldIdx + n - rotations) % n;
            rotatedArr[newIdx] = arr[oldIdx];
        }

        return rotatedArr;
    }
}
