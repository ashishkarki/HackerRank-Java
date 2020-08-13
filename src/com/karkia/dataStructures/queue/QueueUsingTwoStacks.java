package com.karkia.dataStructures.queue;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Stack<Integer> addStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        scanner.nextLine();

        while (numQueries-- > 0) {
            final int opType = scanner.nextInt();
            switch (opType) {
                case 1: // enqueue item x
                    final int enqueueItem = scanner.nextInt();
                    addStack.push(enqueueItem);
                    break;
                case 2: // dequeue
                    while (addStack.size() > 0) {
                        popStack.push(addStack.pop());
                    }

                    popStack.pop();

                    // restore addStack
                    while (popStack.size() > 0) {
                        addStack.push(popStack.pop());
                    }

                    break;
                case 3:
                    while (addStack.size() > 0) {
                        popStack.push(addStack.pop());
                    }

                    System.out.println(popStack.peek());

                    // restore addStack
                    while (popStack.size() > 0) {
                        addStack.push(popStack.pop());
                    }
                    break;
            }
        }
    }
}
