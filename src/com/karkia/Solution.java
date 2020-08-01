package com.karkia;

//Java program to find maximum rectangular area in linear time

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    // The main function to find the maximum rectangular area under given
    // histogram with n bars
    static int getMaxArea(int hist[], int n) {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int topOfStack; // To store top of stack
        int areaWithTopElement; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n) {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else {
                topOfStack = s.pop(); // remove and store the top index

                // Calculate the area with hist[topOfStack] stack as smallest bar
                areaWithTopElement = hist[topOfStack] * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < areaWithTopElement)
                    max_area = areaWithTopElement;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (s.empty() == false) {
            topOfStack = s.pop();
            areaWithTopElement = hist[topOfStack] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < areaWithTopElement) {
                max_area = areaWithTopElement;
            }
        }

        return max_area;

    }

    // Driver program to test above function
    public static void main(String[] args) {
        //int hist[] = {6, 2, 5, 4, 5, 1, 6};
        Scanner in = new Scanner(System.in);
        int numBuildings = in.nextInt();

        int[] hist = new int[numBuildings];
        for (int i = 0; i < numBuildings; i++) {
            hist[i] = in.nextInt();
        }
        in.close();

        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }
}





