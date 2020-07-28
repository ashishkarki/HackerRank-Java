package com.karkia.algorithms.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/luck-balance/problem
public class LuckBalance {
    static int luckBalance(int k, int[][] contests) {
        int maxLuck = 0;
        // remember, if you lose, luck will be subtracted elsed added
        List<Integer> imptContents = new ArrayList<>();

        // build a list of important contents
        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1] != 1) {
                // if these are non-important contests, add to maxLuck
                maxLuck += contests[i][0]; // 0-th has the luck value
            } else {
                imptContents.add(contests[i][0]);
            }
        }

        // sort impt contents in desc. order
        Collections.sort(imptContents, Collections.reverseOrder());

        // Lose the k largest contents (since they will increse luck and
        // we want to minimize the maxLuck) and win the rest
        for (int i = 0; i < imptContents.size(); i++) {
            if (i < k) {
                // we are losing these upto k
                maxLuck += imptContents.get(i);
            } else {
                // we are winning these, so we subtract from maxLuck
                maxLuck -= imptContents.get(i);
            }
        }

        return maxLuck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
