package com.karkia.dataStructures.linkedList;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
public class PrintElementsOfLinkedList {

    // Complete the printLinkedList function below.
    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode curNode = head;
        while (curNode != null) {
            System.out.println(curNode.data);
            curNode = curNode.next;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        printLinkedList(llist.head);

        scanner.close();
    }
}
