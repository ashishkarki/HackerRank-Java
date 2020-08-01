package com.karkia.dataStructures.trees;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/tree-top-view/problem
public class TopNode {
    public static void topView(Node root) {
        if (root == null)
            return;

        printLeft(root.left);
        System.out.print(root.data + " ");
        printRight(root.right);
    }

    private static void printRight(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printRight(root.right);
    }

    private static void printLeft(Node root) {
        if (root == null) {
            return;
        }

        printLeft(root.left);
        System.out.print(root.data + " ");
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
        topView(root);
    }
}
