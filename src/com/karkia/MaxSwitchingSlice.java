package com.karkia;

import java.util.Map;

public class MaxSwitchingSlice {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int indexer = 0;
        int left = 0, right = 0;
        int slices = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] * A[i - 1] > 0) {
                indexer = i + 1;
            } else {
                if (i - indexer > right - left) {
                    right = i;
                    left = indexer;
                    slices = Math.max(slices, right - left + 1);
                }
            }
        }

        return slices;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 3, 2, 3};
        System.out.println(solution(A));
    }
}
