package com.karkia.dataStructures.linkedList.doublyLinkedList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem
//  Time Complexity: O(n)
// Space Complexity: O(1
public class ReverseDoublyLL {
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode cur = head;
        DoublyLinkedListNode next = null;
        while (cur != null) {
            // switch the prev and next links
            next = cur.next;
            cur.next = cur.prev;
            cur.prev = next;

            // move the pointers forward
            prev = cur;
            cur = next;
        }

        return prev;
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

            DoublyLinkedListNode llist1 = reverse(llist.head);

            System.out.println(llist1.toString());
        }

        scanner.close();
    }
}
