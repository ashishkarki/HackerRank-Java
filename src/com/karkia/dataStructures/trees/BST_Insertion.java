package com.karkia.dataStructures.trees;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem?h_r=next-challenge&h_v=zen
class BST_Insertion {
    public static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        Node newNode;
        if (data <= root.data) {
            newNode = insert(root.left, data);
            root.left = newNode;
        } else {
            newNode = insert(root.right, data);
            root.right = newNode;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}
