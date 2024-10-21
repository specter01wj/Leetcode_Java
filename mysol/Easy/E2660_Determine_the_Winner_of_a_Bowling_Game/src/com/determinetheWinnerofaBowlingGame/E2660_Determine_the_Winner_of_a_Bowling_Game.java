package com.determinetheWinnerofaBowlingGame;
import java.util.*;

/*
You are given two 0-indexed integer arrays player1 and player2, 
representing the number of pins that player 1 and player 2 hit 
in a bowling game, respectively.

The bowling game consists of n turns, and the number of pins in 
each turn is exactly 10.

Assume a player hits xi pins in the ith turn. The value of the 
ith turn for the player is:

	. 2xi if the player hits 10 pins in either (i - 1)th or (i - 2)th turn.
	. Otherwise, it is xi.

The score of the player is the sum of the values of their n turns.

Return

	. 1 if the score of player 1 is more than the score of player 2,
	. 2 if the score of player 2 is more than the score of player 1, and
	. 0 in case of a draw.
*/

public class E2660_Determine_the_Winner_of_a_Bowling_Game {

	public static void main(String[] args) {
		E2660_Determine_the_Winner_of_a_Bowling_Game solution = new E2660_Determine_the_Winner_of_a_Bowling_Game();
		int[] player1 = {5,10,3,2};
		int[] player2 = {6,5,7,3};
		int output = solution.isWinner(player1, player2);
        System.out.println("input1: " + Arrays.toString(player1) + 
        		"; input2: " + Arrays.toString(player2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. isWinner method:
		. This method compares the total scores of both players.
		. If player 1 has a higher score, it returns 1.
		. If player 2 has a higher score, it returns 2.
		. If both players have the same score, it returns 0.
	2. calculateScore method:
		. This method calculates the total score for each player.
		. It checks whether the player hit 10 pins in either the previous 
			turn or the turn before that. If so, the current score is doubled.
		. The total score is calculated as the sum of these modified or 
			original turn scores.
    */
	
	/*
     * @param player1: a list of integers
     * @param player1: a list of integers
     * @return: 1 or 2 or 0
     */
	public int isWinner(int[] player1, int[] player2) {
        int score1 = calculateScore(player1);
        int score2 = calculateScore(player2);

        if (score1 > score2) {
            return 1;
        } else if (score2 > score1) {
            return 2;
        } else {
            return 0;
        }
    }

    private int calculateScore(int[] player) {
        int n = player.length;
        int totalScore = 0;

        for (int i = 0; i < n; i++) {
            int currentTurnScore = player[i];

            // Check if the previous or two-turns-ago hit exactly 10 pins
            if (i > 0 && player[i - 1] == 10 || i > 1 && player[i - 2] == 10) {
                currentTurnScore *= 2;
            }

            totalScore += currentTurnScore;
        }

        return totalScore;
    }

}
