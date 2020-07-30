package com.karkia;

import java.util.Scanner;

class Solution {
    //sumDigits function
    static int sumDigits(int n, int sum) {
        // Basic Case to stop the recursion
        System.out.println("n:" + n + ", sum:" + sum);
        if (n == 0) {
            return sum;
        }

        sum = sum + n % 10;  //recursive variable to keep the digits sum
        n = n / 10;
        return sumDigits(n, sum); //returning sum to print it.

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nk = scanner.nextLine().split(" ");
        String p = "";
        for (int i = 0; i < Integer.parseInt(nk[1]); i++) {
            p += nk[0];
        }

        int sum = sumDigits(Integer.parseInt(p), 0);
        while (Integer.toString(sum).length() > 1) {
            sumDigits(sum, 0);
        }
        System.out.println(sum);
    }
}




