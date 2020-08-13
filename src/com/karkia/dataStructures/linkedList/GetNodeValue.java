package com.karkia.dataStructures.linkedList;

// https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

import java.io.IOException;
import java.util.Scanner;

/**
 * Counting backwards from the tail node of the linked list, get the value of the node at the given position.
 * A position of 0 corresponds to the tail, 1 corresponds to the node before the tail and so on.
 */
//  Time Complexity: O(n)
// Space Complexity: O(1)
public class GetNodeValue {
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        // move forward 'fast' by positionFromTail nodes
        for (int i = 0; i < positionFromTail; i++) {
            fast = fast.next;
        }

        // now, move both pointers. Note slow is moving half the speed to fast
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int position = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = getNode(llist.head, position);
            System.out.println(result);
        }

        scanner.close();
    }
}
