package com.karkia.dataStructures.stacks;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/largest-rectangle/problem
public class LargestRectangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numBuildings = in.nextInt();

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int[] heights = new int[numBuildings];
        for (int i = 0; i < numBuildings; i++) {
            heights[i] = in.nextInt();
        }
        in.close();

        for (int i = 0; i <= heights.length; i++) {
            System.out.println("i:" + i);
            final int h = (i == heights.length) ? 0 : heights[i]; // building 0 has height 0
            System.out.println("h: " + h);
            if (stack.size() >= 1) {
                System.out.println("heights[stack.peek()]: " + (heights[stack.peek()]));
            }
            if (stack.isEmpty() || heights[stack.peek()] <= h) {
                // is current height bigger than existing heights in the stack
                stack.push(i);
                System.out.println("pushing, item: " + i);
            } else {
                final int item = stack.pop();
                System.out.println("popping, item: " + item);
                maxArea = Math.max(
                        maxArea,
                        heights[item] * (stack.isEmpty() ? i : i - stack.peek() - 1)
                );
                System.out.println("heights[item]: " + heights[item] + "maxArea: " + maxArea);
                System.out.println("i - stack.peek() - 1:" + (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
            System.out.println("************************");
        }

        System.out.println(maxArea);
    }
}
