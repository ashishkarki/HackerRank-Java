package com.karkia.algorithms.strings;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/beautiful-binary-string/problem
public class BeautifulBinaryString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int binaryStrLen = scanner.nextInt();
        scanner.nextLine(); // move to next line

        String inputStr = scanner.nextLine();
        int changeCount = 0;
        while (inputStr.indexOf("010") != -1) {
            inputStr = inputStr.replaceFirst("010", "011");
            changeCount++;
        }
        System.out.println(changeCount);

        scanner.close();
    }
}
