package com.karkia.dataStructures.trees;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
// Preorder (Root, Left, Right)
public class preorderTraversal {

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

    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        Node curNode;
        if (data <= root.data) {
            curNode = insert(root.left, data);
            root.left = curNode;
        } else {
            curNode = insert(root.right, data);
            root.right = curNode;
        }

        return root;
    }
}
