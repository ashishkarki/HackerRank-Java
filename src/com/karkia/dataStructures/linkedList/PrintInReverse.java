package com.karkia.dataStructures.linkedList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
public class PrintInReverse {
    static void reversePrint(SinglyLinkedListNode head) {
        if (head != null) {
            reversePrint(head.next); // puts all nodes in the stack (which will be reverse)
            System.out.println(head.data);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        reversePrint(llist.head);
        scanner.close();
    }
}


