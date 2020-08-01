package com.karkia.dataStructures.stacks;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/equal-stacks/problem
public class EqualStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt(); // num cylinders in 1st stack
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        Queue<Integer> stack1 = new LinkedList<>();
        Queue<Integer> stack2 = new LinkedList<>();
        Queue<Integer> stack3 = new LinkedList<>();

        int h1 = 0, h2 = 0, h3 = 0; // heights of stacks

        // initialize stacks with their heights
        while (n1-- > 0) {
            final int cylinder = in.nextInt();
            stack1.add(cylinder);
            h1 += cylinder;
        }

        while (n2-- > 0) {
            final int cylinder = in.nextInt();
            stack2.add(cylinder);
            h2 += cylinder;
        }

        while (n3-- > 0) {
            final int cylinder = in.nextInt();
            stack3.add(cylinder);
            h3 += cylinder;
        }

        // assume stack with smallest height, we will adjust other heights to this height
        int minStack = Math.min(h1, Math.min(h2, h3));

        while (h1 != h2 || h2 != h3) {
            // loop until all heights aren't equal
            while (h1 > minStack) {
                h1 -= stack1.remove();
            }
            minStack = Math.min(h1, Math.min(h2, h3));

            while (h2 > minStack) {
                h2 -= stack2.remove();
            }
            minStack = Math.min(h1, Math.min(h2, h3));

            while (h3 > minStack) {
                h3 -= stack3.remove();
            }
            minStack = Math.min(h1, Math.min(h2, h3));
        }

        System.out.println(minStack);
    }
}
