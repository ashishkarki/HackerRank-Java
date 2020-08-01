package com.karkia.dataStructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
public class LevelOrderTraversal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }

    private static void levelOrder(Node root) {
        if (root == null) {
            System.out.println("");
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            System.out.print(curNode.data + " ");
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
    }

    private static Node insert(Node root, int data) {
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
}
