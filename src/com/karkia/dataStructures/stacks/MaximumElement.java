package com.karkia.dataStructures.stacks;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/maximum-element
public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        scanner.nextLine();

        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        maxStack.push(Integer.MIN_VALUE);

        for (int i = 0; i < numQueries; i++) {
            int operationType = scanner.nextInt();
            switch (operationType) {
                case 1:
                    int item = scanner.nextInt();
                    mainStack.push(item);

                    int maxSoFar = maxStack.peek();
                    if (item > maxSoFar) {
                        maxStack.push(item);
                    } else {
                        maxStack.push(maxSoFar);
                    }
                    break;
                case 2:
                    mainStack.pop();
                    maxStack.pop();
                    break;
                case 3:
                    System.out.println(maxStack.peek());
                    break;
            }
        }
        scanner.close();
    }
}
