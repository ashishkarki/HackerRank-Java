package com.karkia.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  Time Complexity: O(n + m)
// Space Complexity: O(1)
public class MyClimbingTheLeaderboard {
    public static void main(String[] args) {
        // save input by discarding duplicates to build our leaderboard
        Scanner scanner = new Scanner(System.in);

        int numPlayersAlreadyOnLeaderboard = scanner.nextInt();
        int lastScore = -1; // lastScore in order to eliminate duplicates

        //int[] leaderboardScores = new int[numPlayersAlreadyOnLeaderboard];
        List<Integer> leaderboardScoresList = new ArrayList<>();

        // tracks number of unique scores and thus the ranks (which in the question start from 1)
        int uniqueScoreCountOrRank = 1;

        // read scores and calculate ranks
        while (numPlayersAlreadyOnLeaderboard-- > 0) {
            int currentScore = scanner.nextInt(); // current leaderboard score are descending arranged
            if (currentScore != lastScore) {
                // meaning if this score hasn't already been processed
                leaderboardScoresList.add(currentScore); // deduct 1, as uniqueScoreCountOrRank is 1-based
                uniqueScoreCountOrRank++; // each unique score means a new rank in descending order
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

        // // Next, Calculate Alice's ranks and print them

        // subtract 1 since we went 1 ahead while reading leaderboard score above //
        int index = uniqueScoreCountOrRank - 1;
        for (int aliceScore : aliceScores) {
            while (index > 0) { // uniqueScoreCountOrRank can go up to 1st rank
                // uniqueScoreCountOrRank starts at 1 - the position of the currently highest rated player
                // hence, we go up to that point - before zero with while loop above

                if (aliceScore < leaderboardScoresList.get(index-1)) {
                    // this aliceScore is less than some "index" score in the existing leaderboard
                    // so, this aliceScore is supposed to be 1 less than currently compared lb. score
                    // since, the highest rank starts at 1 and goes down with higher values, we add 1 to lower alice's rank
                    System.out.println(index + 1);
                    break; // since, we found a rank for this  aliceScore, don't compare with leaderboard further
                }
                // if no break above, move up 1 level in leaderboardScores in order to compare with a higher score and lesser rank
                index--;
            }

            // if we above and beyond the leaderboard scores/ranks, it means alice has the highest score of 1
            if (index < 1) { // remember, 1 is supposed to be the highest ranked player
                System.out.println(1);
            }
        }
    }
}
