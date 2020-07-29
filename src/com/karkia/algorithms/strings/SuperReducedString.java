package com.karkia.algorithms.strings;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/reduced-string/problem
//  Time Complexity: O(n)
// Space Complexity: O(n)
public class SuperReducedString {
    static String reduceString(String s) {
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            final Character curChar = s.charAt(i);
            if (!charStack.isEmpty() && curChar == charStack.peek()) {
                // if the next (peek) character is same as current char
                charStack.pop(); // we pop one and don't add one into the stack
            } else {
                charStack.push(curChar);
            }
        }

        // return result
        if (charStack.isEmpty()) {
            return "Empty String";
        } else {
            StringBuffer sb = new StringBuffer();
            for (char ch : charStack) {
                sb.append(ch);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        System.out.println(reduceString(inputStr));
    }
}
