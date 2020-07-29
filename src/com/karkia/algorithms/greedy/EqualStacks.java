package com.karkia.algorithms.greedy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/equal-stacks/problem
/*
Sample Input:
5 3 4 => num of cylinders in stacks 1, 2 and 3
3 2 1 1 1 => cylinder heights in stack 1
4 3 2 => cylinder heights in stack 2
1 1 4 1 => cylinder heights in stack 3

Time Complexity: O(n) //We must look at every element in the worst case //n = n1+n2+n3
Space Complexity: O(n) //After initialization our stacks take up n space //n = n1+n2+n3
 */
public class EqualStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt(); // num cylinders in 1st stack
        int n2 = in.nextInt(); // num cylinders in 2nd stack
        int n3 = in.nextInt(); // num cylinders in 3rd stack

        Queue<Integer> stack1 = new LinkedList<>(); // 1st stack of cylinders
        Queue<Integer> stack2 = new LinkedList<>(); // 2nd stack of cylinders
        Queue<Integer> stack3 = new LinkedList<>(); // 3rd stack of cylinders

        int h1 = 0; // height of 1st stack
        int h2 = 0;
        int h3 = 0;

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

        // the stack with the smallest height - we will adjust other heights to this height
        int minStack = Math.min(h1, Math.min(h2, h3));

        while (h1 != h2 || h1 != h3) {
            // loop until all heights aren't equal
            // remove cylinders from given stack until that stack's height <= minStack
            // then re-calculate the minStack height
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

        // this min height represents the equal heights of all stacks
        System.out.println(minStack);
    }
}
