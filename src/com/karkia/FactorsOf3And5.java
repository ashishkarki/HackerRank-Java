package com.karkia;

import java.io.*;
import java.util.Scanner;

class Result {

    /*
     * Complete the 'getIdealNums' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER low
     *  2. LONG_INTEGER high
     */

    public static long getIdealNums(long low, long high) {
        // Write your code here
        int idealNumCount = 0;

        if (low == 1) {
            idealNumCount++;
            low++;
        }

        for (long i = low; i <= high; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                break;
            }
            System.out.println("found something divisble by 3/5: " + i);

            idealNumCount++;
        }

        return idealNumCount;
    }

}

public class FactorsOf3And5 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        long low = Long.parseLong(scan.next());

        long high = Long.parseLong(scan.next());

        long result = Result.getIdealNums(low, high);

        System.out.println("result is " + result);
    }
}

