package com.karkia.dataStructures.trees;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/tree-postorder-traversal/problem
public class PostorderTraversal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        postOrder(root);
    }

    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
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
