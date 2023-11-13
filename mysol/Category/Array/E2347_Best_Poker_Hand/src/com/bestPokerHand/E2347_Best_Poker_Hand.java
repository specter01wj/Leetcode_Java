package com.bestPokerHand;
import java.util.*;

/*
You are given an integer array ranks and a character array suits. 
You have 5 cards where the ith card has a rank of ranks[i] and a suit of suits[i].

The following are the types of poker hands you can make from best to worst:

1. "Flush": Five cards of the same suit.
2. "Three of a Kind": Three cards of the same rank.
3. "Pair": Two cards of the same rank.
4. "High Card": Any single card.

Return a string representing the best type of poker hand you can make with the given cards.

Note that the return values are case-sensitive.


Example 1:

Input: ranks = [13,2,3,1,9], suits = ["a","a","a","a","a"]
Output: "Flush"
Explanation: The hand with all the cards consists of 5 cards with the same suit, 
so we have a "Flush".

Example 2:

Input: ranks = [4,4,2,4,4], suits = ["d","a","a","b","c"]
Output: "Three of a Kind"
Explanation: The hand with the first, second, and fourth card consists of 3 cards 
with the same rank, so we have a "Three of a Kind".
Note that we could also make a "Pair" hand but "Three of a Kind" is a better hand.
Also note that other cards could be used to make the "Three of a Kind" hand.

Example 3:

Input: ranks = [10,10,2,12,9], suits = ["a","b","c","a","d"]
Output: "Pair"
Explanation: The hand with the first and second card consists of 2 cards 
with the same rank, so we have a "Pair".
Note that we cannot make a "Flush" or a "Three of a Kind".
*/

public class E2347_Best_Poker_Hand {

	public static void main(String[] args) {
		int[] input = {13,2,3,1,9};
		char[] suits = {'a','a','a','a','a'};
		String output = bestHand(input, suits);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static String bestHand(int[] ranks, char[] suits) {
		int[] cnt = new int[14];
		int max = 0;
		
		for (int rank : ranks) {
			cnt[rank]++;
			if (cnt[rank] > max) {
				max = cnt[rank];
			}
		}
		
		if (suits[0] == suits[1] && suits[1] == suits[2] && suits[2] == suits[3] && suits[3] == suits[4]) {
			return "Flush";
		}
		
		if (max >= 3) {
			return "Three of a Kind";
        } else if (max == 2) {
            return "Pair";
        } else {
            return "High Card";
		}
	}

}
