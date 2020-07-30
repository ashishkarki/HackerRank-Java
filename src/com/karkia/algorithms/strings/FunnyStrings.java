package com.karkia.algorithms.strings;

import java.util.Scanner;

public class FunnyStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        scanner.nextLine();

        while (numQueries-- > 0) {
            final String inputStr = scanner.nextLine();
            final int inputLen = inputStr.length();
            boolean isFunny = true;

            for (int i = 1; i < inputLen / 2 + 1; i++) {
                // check if characters are two ends are same
                final int leftSideDiff = Math.abs(inputStr.charAt(i) - inputStr.charAt(i - 1));
                final int rightSideDiff = Math.abs(inputStr.charAt(inputLen - i - 1) - inputStr.charAt(inputLen - i));
                if (leftSideDiff != rightSideDiff) {
                    isFunny = false;
                    break;
                }
            }
            System.out.println(isFunny ? "Funny" : "Not Funny");
        }
        scanner.close();
    }
}
