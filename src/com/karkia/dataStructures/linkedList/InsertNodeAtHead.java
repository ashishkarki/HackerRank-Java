package com.karkia.dataStructures.linkedList;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem
// Insert the new node at the head and
// return the head of the updated linked list
public class InsertNodeAtHead {
    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode curNode = head;
        while (curNode != null) {
            System.out.println(curNode.data);
            curNode = curNode.next;
        }
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        var newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            return newNode;
        }

        newNode.next = head;
        head = newNode;

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

            SinglyLinkedListNode llist_head = insertNodeAtHead(llist.head, llistItem);

            llist.head = llist_head;
        }

        printLinkedList(llist.head);
        scanner.close();
    }
}
