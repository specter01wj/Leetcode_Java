package com.minimumCardPickup;
import java.util.*;

/*
You are given an integer array cards where cards[i] represents 
the value of the ith card. A pair of cards are matching if 
the cards have the same value.

Return the minimum number of consecutive cards you have to pick 
up to have a pair of matching cards among the picked cards. 
If it is impossible to have matching cards, return -1.
*/

public class Ch3_minimumCardPickup {

	public static void main(String[] args) {
		Ch3_minimumCardPickup solution = new Ch3_minimumCardPickup();
		int[] input = {3,4,2,3,4,7};
		int output = solution.minimumCardPickup(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];
            if (lastSeen.containsKey(card)) {
                minLength = Math.min(minLength, i - lastSeen.get(card) + 1);
            }
            lastSeen.put(card, i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

}
