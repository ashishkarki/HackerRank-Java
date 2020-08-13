package com.karkia.dataStructures.queue;

import java.util.Scanner;
import java.util.Stack;

// https://github.com/RodneyShag/HackerRank_solutions/blob/master/Data%20Structures/Queues/Queue%20using%20Two%20Stacks/Solution.java
public class QueueUsingTwoStacks2 {
    public static void main(String[] args) {
        QueueFromStacks<Integer> queue = new QueueFromStacks<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static class QueueFromStacks<T> {
        Stack<T> addStack = new Stack<>();
        Stack<T> popStack = new Stack<>();

        public void enqueue(T item) {
            addStack.push(item);
        }

        public T dequeue() {
            if (totalSize() == 0) {
                return null;
            }

            moveItemFromAddToPopStack();

            return popStack.pop();
        }

        public T peek() {
            if (totalSize() == 0) {
                return null;
            }

            moveItemFromAddToPopStack();

            return popStack.peek();
        }

        private void moveItemFromAddToPopStack() {
            if (popStack.isEmpty()) {
                while (!addStack.isEmpty()) {
                    popStack.push(addStack.pop());
                }
            }
        }

        private int totalSize() {
            return addStack.size() + popStack.size();
        }
    }
}
