package com.karkia.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-vistor-pattern/problem
enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // since this is about leaf, do nothing here
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final int M = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafEvenDepthSum = 0;
    private int greenLeavesSum = 0;

    public int getResult() {
        return Math.abs(nonLeafEvenDepthSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonLeafEvenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeavesSum += leaf.getValue();
        }
    }
}

public class JavaVisitorPattern {
    static int[] values;
    static Color[] colors;
    static List<Integer>[] edges;

    public static Tree solve() {
        TreeNode root;
        Scanner sc = new Scanner(System.in);

        int numNodes = sc.nextInt();
        values = new int[numNodes];
        colors = new Color[numNodes];

        for (int i = 0; i < numNodes; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 0; i < numNodes; i++) {
            colors[i] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        // save all the edges
        edges = (ArrayList<Integer>[]) new ArrayList[numNodes + 1];
        for (int i = 1; i < numNodes; i++) {
            edges[i] = new ArrayList<>();
        }

        // read n-1 edges and store them in both directions
        for (int i = 0; i < numNodes - 1; i++) {
            int edgeNode1 = sc.nextInt();
            int edgeNode2 = sc.nextInt();
            edges[edgeNode1].add(edgeNode2);
            edges[edgeNode2].add(edgeNode1);
        }

        sc.close();

        root = new TreeNode(values[0], colors[0], 0);
        addChildren(root, 1);

        return root;
    }

    public static void addChildren(Tree node, Integer nodeNum) {
        // find and loop through all the edges of this nodeNum
        for (Integer nodeNumInOtherEdge : edges[nodeNum]) {
            Tree nodeInOtherEdge;
            if (edges[nodeNumInOtherEdge].size() > 1) {
                // new non-leaf node
                nodeInOtherEdge = new TreeNode(
                        values[nodeNumInOtherEdge - 1],
                        colors[nodeNumInOtherEdge - 1],
                        node.getDepth() + 1
                );
            } else {
                // new leaf node
                nodeInOtherEdge = new TreeLeaf(
                        values[nodeNumInOtherEdge - 1],
                        colors[nodeNumInOtherEdge - 1],
                        node.getDepth() + 1
                );
            }

            ((TreeNode) node).addChild(nodeInOtherEdge);
            edges[nodeNumInOtherEdge].remove(nodeNum);

            if (nodeInOtherEdge instanceof TreeNode) {
                addChildren(nodeInOtherEdge, nodeNumInOtherEdge);
            }
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}