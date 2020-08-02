package com.karkia.dataStructures.linkedList;

import java.io.IOException;
import java.util.Scanner;

public class MergeTwoSortedLL {
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        } else if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
//        else if (head1.data < head2.data) {
//            head1.next = mergeLists(head1.next, head2);
//            return head1;
//        } else {
//            head2.next = mergeLists(head1, head2.next);
//            return head2;
//        }


        SinglyLinkedListNode resultHead = new SinglyLinkedListNode(Integer.MIN_VALUE);
        SinglyLinkedListNode mergedCurNode = resultHead;
        SinglyLinkedListNode curNode1 = head1;
        SinglyLinkedListNode curNode2 = head2;
        while (curNode1 != null && curNode2 != null) {
            if (curNode1.data < curNode2.data) {
                mergedCurNode.next = curNode1;
                curNode1 = curNode1.next; // in next cycle, check next node in head1
            } else {
                mergedCurNode.next = curNode2;
                curNode2 = curNode2.next;
            }

            mergedCurNode = mergedCurNode.next;
        }

        // add any remaining nodes
        if (curNode1 == null) {
            mergedCurNode.next = curNode2;
        } else {
            mergedCurNode.next = curNode1;
        }

        return resultHead.next; // since, our head is a Integer.MIN dummy node
    }

    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
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

            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);
            printLinkedList(llist3);
        }

        scanner.close();
    }
}
