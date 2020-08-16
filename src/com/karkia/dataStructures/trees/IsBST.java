package com.karkia.dataStructures.trees;

/**
 * Reference: https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 * Time Complexity: O(n)
 * Auxiliary Space : O(1) if Function Call Stack size is not considered, otherwise O(n)
 */
public class IsBST {

    private static Node newNode(int data) {
        return new Node(data);
    }

    public static boolean isBST(Node root, Node left, Node right) {
        // if we reached this point after everything, then true
        if (root == null) {
            return true;
        }

        // if there is a left node and its left.data < root.data
        if (left != null && left.data >= root.data) {
            return false;
        }

        // if there is a right node and its right.data > root.data
        if (right != null && right.data <= root.data) {
            return false;
        }

        return isBST(root.left, left, root) &&
                isBST(root.right, root, right);
    }

    // Driver code
    public static void main(String[] args) {
        Node root = newNode(3);
        root.left = newNode(2);
        root.right = newNode(5);
        root.left.left = newNode(1);
        root.left.right = newNode(4);

        if (isBST(root, null, null))
            System.out.print("Is BST");
        else
            System.out.print("Not a BST");
    }
}
