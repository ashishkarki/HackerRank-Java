package com.karkia.java;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack_BalancedParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String inputPattern = scanner.nextLine();

            System.out.println(checkParentheses(inputPattern));
        }

        scanner.close();
    }

    private static boolean checkParentheses(String inputPattern) {
        Stack<Character> stack = new Stack<>();
        char[] chars = inputPattern.toCharArray();

        for (char ch : chars) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (ch == ']' && !stack.isEmpty() && stack.pop() == '[') {
                    // everything is good, there is a matching paren
                    continue;
                } else if (ch == '}' && !stack.isEmpty() && stack.pop() == '{') {
                    // everything is good, there is a matching paren
                    continue;
                } else if (ch == ')' && !stack.isEmpty() && stack.pop() == '(') {
                    // everything is good, there is a matching paren
                    continue;
                } else {
                    return false;
                }
            }
        }

        // if everything else above looks good, we want the stack to be empty
        // so we know no lingering parentheses is present
        return stack.isEmpty();
    }
}
