package com.karkia.dataStructures.stacks;

import java.util.*;

// https://www.hackerrank.com/challenges/balanced-brackets/problem
public class BalancedBrackets {

    public static void main(String[] args) {
        final Map<Character, Character> matchingMap = new HashMap<>();
        matchingMap.put('(', ')');
        matchingMap.put('[', ']');
        matchingMap.put('{', '}');

        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        scanner.nextLine();

        while (numQueries-- > 0) {
            String inputStr = scanner.next();
            System.out.println(areBracketsBalanced(inputStr, matchingMap) ? "YES" : "NO");
        }

        scanner.close();
    }

    private static boolean areBracketsBalanced(String inputStr, Map<Character, Character> matchingMap) {
        if (inputStr.length() % 2 != 0) {
            return false; // odd length strings cannot be balanced
        }

        Deque<Character> deque = new ArrayDeque<>();// using deque as stack
        for (int i = 0; i < inputStr.length(); i++) {
            final Character ch = inputStr.charAt(i);
            if (matchingMap.containsKey(ch)) {
                deque.push(ch);
            } else if (deque.isEmpty() || ch != matchingMap.get(deque.pop())) {
                // if prematurely empty or there is no matching starting bracket for this ending bracket
                return false;
            }
        }

        // if all above is good, depends on if deque is cleanly empty
        return deque.isEmpty();
    }
}
