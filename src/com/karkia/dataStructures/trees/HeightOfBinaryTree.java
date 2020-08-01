package com.karkia.dataStructures.trees;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.println(height(root));
    }

    private static int height(Node root) {
        if (root == null) {
            return -1; // if return 0, then don't add 1 below
        }

        return 1 + Math.max(
                height(root.left),
                height(root.right)
        );
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
