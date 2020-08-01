package com.karkia.dataStructures.stacks;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/simple-text-editor/problem
public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOperations = in.nextInt();
        in.nextLine();

        String s = "";
        Stack<String> stack = new Stack<>();
        stack.push("");

        while (numOperations-- > 0) {
            final int operationType = in.nextInt();
            switch (operationType) {
                case 1: // add new input
                    s = stack.peek() + in.next();
                    stack.push(s);
                    break;
                case 2://delete last k characters
                    if (!stack.isEmpty()) {
                        final int charsToDelete = in.nextInt();
                        final String peekedStr = stack.peek();
                        s = peekedStr.substring(0, peekedStr.length() - charsToDelete);
                        stack.push(s);
                    }
                    break;
                case 3: // print kth character
                    if (!stack.isEmpty()) {
                        final int charToPrint = in.nextInt();
                        s = stack.peek();
                        final int ch = s.charAt(charToPrint - 1);
                        System.out.println((char) ch);
                    }
                    break;
                case 4: // undo either append or delete
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
            }
        }
        in.close();
    }
}
