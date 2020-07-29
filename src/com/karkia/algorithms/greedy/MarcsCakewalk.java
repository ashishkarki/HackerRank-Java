package com.karkia.algorithms.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MarcsCakewalk {

    // Complete the marcsCakewalk function below.
    static long marcsCakewalk(Integer[] calories) {
        Arrays.sort(calories, Collections.reverseOrder());
        long multiplier = 1;
        long miles = 0;

        for (Integer calorie : calories) {
            miles += calorie * multiplier;
            multiplier *= 2;
        }

        return miles;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Integer[] calories = new Integer[n];

        String[] calorieItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int calorieItem = Integer.parseInt(calorieItems[i]);
            calories[i] = calorieItem;
        }

        long result = marcsCakewalk(calories);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}