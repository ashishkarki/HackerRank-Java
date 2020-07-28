package com.karkia.java;

import java.util.*;

// https://www.hackerrank.com/challenges/java-dequeue/problem
public class JavaDequeue2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int subarraySize = in.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int maxUnique = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int inputInt = in.nextInt();
            deque.add(inputInt); // add at the tail
            set.add(inputInt);

            if (deque.size() == subarraySize) {
                maxUnique = Math.max(set.size(), maxUnique);

                System.out.println("Printing deque items before remove");
                for (int dq :
                        deque) {
                    System.out.println(dq);
                }
                int firstDqItem = deque.remove();
                System.out.println("first dq: " + firstDqItem);
                // if this item is unique in deque, remove it from stack
                // since it has already been taken into account
                if (!deque.contains(firstDqItem)) { // is there another item like firstDqItem
                    System.out.println("Before");
                    for (int item :
                            set) {
                        System.out.print(item + " ");
                    }
                    System.out.println("\n*******Before**********");
                    set.remove(firstDqItem);
                    System.out.println("After");
                    for (int item :
                            set) {
                        System.out.print(item + " ");
                    }
                    System.out.println("\n*******After**********");
                }
            }
        }

        in.close();
        System.out.println(maxUnique);
    }
}
