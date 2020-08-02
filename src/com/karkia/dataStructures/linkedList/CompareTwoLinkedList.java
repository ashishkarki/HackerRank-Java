package com.karkia.dataStructures.linkedList;

import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/compare-two-linked-lists/problem?h_r=next-challenge&h_v=zen
public class CompareTwoLinkedList {
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null || head2 == null) {
            return false;
        }

        SinglyLinkedListNode curNode1 = head1;
        SinglyLinkedListNode curNode2 = head2;
        while (curNode1 != null && curNode2 != null) {
            if (curNode1.data != curNode2.data) {
                return false;
            }

            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }

        if (curNode1 != null || curNode2 != null) {
            return false;
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }

            SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            boolean result = compareLists(llist1.head, llist2.head);
            System.out.println(result);
        }

        scanner.close();
    }
}
