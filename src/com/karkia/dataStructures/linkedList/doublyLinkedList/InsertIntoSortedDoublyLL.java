package com.karkia.dataStructures.linkedList.doublyLinkedList;

import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
//  Time Complexity: O(n)
// Space Complexity: O(1)
public class InsertIntoSortedDoublyLL {
    // Complete the sortedInsert function below.
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (head == null) {
            return newNode;
        } else if (data < head.data) { // insert as new head
            newNode.next = head;
            head.prev = newNode;
            return newNode; //newNode is the head now
        } else {
            // use two pointers to walk the list
            DoublyLinkedListNode n1 = null;
            DoublyLinkedListNode n2 = head;

            while (n2 != null && n2.data < data) {
                n1 = n2;
                n2 = n2.next;
            }

            n1.next = newNode;
            if (n2 == null) { // insert at the end of list
                newNode.prev = n1;
            } else { // else, insert somewhere in between
                n2.prev = newNode;
                newNode.prev = n1;
                newNode.next = n2;
            }

            return head;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

            System.out.println(llist1.toString());
        }

        scanner.close();
    }
}

