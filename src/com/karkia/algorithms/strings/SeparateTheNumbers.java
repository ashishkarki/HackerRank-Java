package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/separate-the-numbers/problem
// time: O(n) - loop through n-length of inputStr
// space: O(n) - save/store inputStr of length n in memory
public class SeparateTheNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = Integer.parseInt(scanner.nextLine());

        while (numQueries-- > 0) {
            final String inputStr = scanner.nextLine();
            System.out.println(numberSeparator(inputStr));
        }
        scanner.close();
    }

    private static String numberSeparator(String s) {
        boolean valid = false;
        String subStr = "";

        for (int i = 1; i <= s.length() / 2; i++) { // start with substring size=1
            subStr = s.substring(0, i);
            Long numSubStr = Long.parseLong(subStr);
            String validStr = subStr; // assume initial subStr is a valid string and keep adding to it

            while (validStr.length() < s.length()) {
                validStr += Long.toString(++numSubStr); // eg: increase 9 to 10 and concat as string
            }

            if (s.equals(validStr)) {
                valid = true;
                break;
            } // otherwise, form a new substr of 1+ bigger length
        }

        return valid ? "YES " + subStr : "NO";
    }
}
