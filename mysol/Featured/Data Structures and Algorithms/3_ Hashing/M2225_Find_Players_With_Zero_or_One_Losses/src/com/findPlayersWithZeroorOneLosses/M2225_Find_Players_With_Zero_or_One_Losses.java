package com.findPlayersWithZeroorOneLosses;
import java.util.*;

/*
You are given an integer array matches where matches[i] = [winneri, loseri] 
indicates that the player winneri defeated player loseri in a match.

Return a list answer of size 2 where:

	. answer[0] is a list of all players that have not lost any matches.
	. answer[1] is a list of all players that have lost exactly one match.

The values in the two lists should be returned in increasing order.
*/

public class M2225_Find_Players_With_Zero_or_One_Losses {

	public static void main(String[] args) {
		M2225_Find_Players_With_Zero_or_One_Losses solution = new M2225_Find_Players_With_Zero_or_One_Losses();
		int[][] input = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
		List<List<Integer>> output = solution.findWinners(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>();
        Set<Integer> allPlayers = new HashSet<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            // Count the loss
            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);

            // Track all players who played
            allPlayers.add(winner);
            allPlayers.add(loser);
        }

        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int player : allPlayers) {
            int losses = lossCount.getOrDefault(player, 0);
            if (losses == 0) {
                noLoss.add(player);
            } else if (losses == 1) {
                oneLoss.add(player);
            }
        }

        Collections.sort(noLoss);
        Collections.sort(oneLoss);

        List<List<Integer>> result = new ArrayList<>();
        result.add(noLoss);
        result.add(oneLoss);

        return result;
    }

}
