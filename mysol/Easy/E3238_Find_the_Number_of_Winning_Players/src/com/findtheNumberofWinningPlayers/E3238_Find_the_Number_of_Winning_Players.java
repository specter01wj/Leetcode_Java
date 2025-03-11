package com.findtheNumberofWinningPlayers;
import java.util.*;

/*
You are given an integer n representing the number of players 
in a game and a 2D array pick where pick[i] = [xi, yi] represents 
that the player xi picked a ball of color yi.

Player i wins the game if they pick strictly more than i balls 
of the same color. In other words,

	. Player 0 wins if they pick any ball.
	. Player 1 wins if they pick at least two balls of the same color.
	. ...
	. Player i wins if they pick at leasti + 1 balls of the same color.

Return the number of players who win the game.
*/

public class E3238_Find_the_Number_of_Winning_Players {

	public static void main(String[] args) {
		E3238_Find_the_Number_of_Winning_Players solution = new E3238_Find_the_Number_of_Winning_Players();
		int n = 4;
		int[][] input = {{0,0},{1,0},{1,0},{2,1},{2,1},{2,0}};
		int output = solution.winningPlayerCount(n, input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. We use a HashMap<Integer, HashMap<Integer, Integer>> to track the count of each color picked by each player.
	2. We iterate over the pick array and populate this map.
	3. After gathering counts, we check each player's color counts to see if they exceed their player number.
	4. If any color count surpasses the required threshold (player index + 1), the player is counted as a winner.
	5. The final count of winning players is returned.
    */
	
	/*
     * @param n: an integer
     * @param pick: a list of integers
     * @return: the number of players who win the game
     */
	public int winningPlayerCount(int n, int[][] pick) {
        // Map to store player -> (color -> count) mapping
        Map<Integer, Map<Integer, Integer>> playerMap = new HashMap<>();

        // Count the number of balls of each color picked by each player
        for (int[] p : pick) {
            int player = p[0], color = p[1];
            playerMap.putIfAbsent(player, new HashMap<>());
            playerMap.get(player).put(color, playerMap.get(player).getOrDefault(color, 0) + 1);
        }

        int count = 0;

        // Check which players meet the winning condition
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : playerMap.entrySet()) {
            int player = entry.getKey();
            for (int ballCount : entry.getValue().values()) {
                if (ballCount > player) {
                    count++;
                    break; // No need to check further colors for this player
                }
            }
        }

        return count;
    }

}
