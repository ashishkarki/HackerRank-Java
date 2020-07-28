package com.karkia.algorithms;

import java.util.Scanner;

//  Time Complexity: O(n + m)
// Space Complexity: O(1)
public class ClimbingTheLeaderboard {
    public static void main(String[] args) {
        // save input by discarding duplicates to build our leaderboard
        Scanner scanner = new Scanner(System.in);

        int numPlayersOnLeaderboard = scanner.nextInt();
        int lastScore = -1; // lastScore in order to eliminate duplicates

        int[] leaderboardScores = new int[numPlayersOnLeaderboard];
        int uniqueScoreOrRank = 0; // tracks number of unique scores and thus the ranks

        // read scores and calculate ranks
        while (numPlayersOnLeaderboard-- > 0) {
            int currentScore = scanner.nextInt();
            if (currentScore != lastScore) {
                // meaning if this score hasn't already been processed
                leaderboardScores[uniqueScoreOrRank] = currentScore;
                uniqueScoreOrRank++;
            }
            lastScore = currentScore;
        }

        // now, read Alice's score - she is going to be a new player
        int numOfAliceScores = scanner.nextInt();
        int[] aliceScores = new int[numOfAliceScores];
        for (int i = 0; i < numOfAliceScores; i++) {
            aliceScores[i] = scanner.nextInt();
        }

        scanner.close();

        // Calculate Alice's ranks and print them

        // subtract 1 since we went 1 ahead while reading leaderboard score above
        int index = uniqueScoreOrRank - 1;
        for (int aliceScore : aliceScores) {
            while (index >= 0) {
                // uniqueScoreOrRank starts at 0 - the position of the currently highest rated player
                // hence, we go upto that point - zero with while loop
                if (aliceScore < leaderboardScores[index]) {
                    // this score of alice is less than some score in the existing leaderboard
                    // so, this aliceScore is supposed to be 1 less than currently compared lb. score
                    // however, since we made our uniqueScoreOrRank 0-based, to correctly print the rank
                    // we have to add 1 more to the "index" of currently compared lb. score
                    System.out.println(index + 2);
                    break;
                }
                // if no break above, move up 1 level in leaderboardScores since we are done comparing with current score
                index--;
            }

            // if we above and beyond the leaderboard scores/ranks, it means alice has the highest score of 1
            if (index < 0) {
                System.out.println(1);
            }
        }
    }
}
