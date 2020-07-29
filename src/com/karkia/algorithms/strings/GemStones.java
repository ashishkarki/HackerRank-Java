package com.karkia.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/challenges/gem-stones/problem
// time complexity: O(n), space complexity: O(1)
public class GemStones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        scanner.nextLine();

        // read the first string into our set
        Set<Character> gemstones = getSetFromString(scanner.nextLine());

        // read remaining strings
        for (int i = 1; i < arrSize; i++) {
            // performs intersection with existing items in gemstones set
            gemstones.retainAll(getSetFromString(scanner.nextLine()));
        }

        // the size of the set is the number of common characters/minerals
        System.out.println(gemstones.size());
    }

    static Set<Character> getSetFromString(String s) {
        Set<Character> set = new HashSet<>(26);
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        return set;
    }
}
