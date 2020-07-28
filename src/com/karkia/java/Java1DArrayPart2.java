package com.karkia.java;

import java.util.List;
import java.util.Scanner;

public class Java1DArrayPart2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();

        for (int i = 0; i < numQueries; i++) {
            int n = scanner.nextInt();
            int leap = scanner.nextInt();

            int[] game = new int[n];
            for (int j = 0; j < n; j++) {
                game[j] = scanner.nextInt();
            }

            System.out.println(canWin(game, leap) ? "YES" : "NO");
        }

        scanner.close();
    }

    private static boolean canWin(int[] game, int leap) {
        return canWin(game, leap, 0);
    }

    private static boolean canWin(int[] game, int leap, int i) {
        if (i < 0 || game[i] == 1) {
            return false;
        }

        if (i + leap >= game.length || i == game.length - 1) {
            return true;
        }

        game[i] = 1; // if nothing above, mark this bit/part as visited

        return canWin(game, leap, i + 1) ||
                canWin(game, leap, i + leap) ||
                canWin(game, leap, i - 1);
    }
}
