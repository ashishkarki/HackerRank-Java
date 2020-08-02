package com.karkia.dataStructures.linkedList;

import java.util.Scanner;

public class InsertNodeAtTail {
    // https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode curNode = head;
        while (curNode != null) {
            System.out.println(curNode.data);
            curNode = curNode.next;
        }
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            return newNode;
        }

        SinglyLinkedListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        // we reached the last node that 'tail' points to
        curNode.next = newNode;

        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

            llist.head = llist_head;
        }

        printLinkedList(llist.head);
        scanner.close();
    }
}
