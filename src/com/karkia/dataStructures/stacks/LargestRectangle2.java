package com.karkia.dataStructures.stacks;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// https://gist.github.com/mykolaveremeichyk/af671925d24e02fec1b196f39bd254fd
public class LargestRectangle2 {
    private static Map<Integer, Integer> buildings = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int N = sn.nextInt();
        for (int i = 0; i < N; i++) {
            buildings.put(i, sn.nextInt());
        }

        int maxArea = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            int area = buildings.get(i);
            int leftArea = goLeft(i, area); // can this area expand to its left
            int rightArea = goRight(i, area); // can this area expand to its right
            sum = area + leftArea + rightArea;
            if (sum > maxArea) {
                maxArea = sum;
            }
        }
        sn.close();
        System.out.println(maxArea);
    }

    private static int goLeft(int refIndex, int refArea) {
        // can the refArea in the refIndex expand towards its left
        // it can expand until curArea >= refArea
        int sum = 0;
        if (refIndex != 0) {
            for (int leftIndex = refIndex - 1; leftIndex >= 0; leftIndex--) {
                int curArea = buildings.get(leftIndex);
                if (curArea < refArea) {
                    break; // since the building to the left is smaller than refArea, we cannot expand anymore
                }
                sum += refArea;
            }
        }

        return sum;
    }

    private static int goRight(int refIndex, int refArea) {
        int sum = 0;
        if (refIndex != buildings.size() - 1) {
            for (int rightIndex = refIndex + 1; rightIndex < buildings.size(); rightIndex++) {
                int curArea = buildings.get(rightIndex);
                if (curArea < refArea) {
                    break;
                }
                sum += refArea;
            }
        }

        return sum;
    }
}
