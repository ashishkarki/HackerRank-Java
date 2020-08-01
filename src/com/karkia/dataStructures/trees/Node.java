package com.karkia.dataStructures.trees;

// based on https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
public class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
