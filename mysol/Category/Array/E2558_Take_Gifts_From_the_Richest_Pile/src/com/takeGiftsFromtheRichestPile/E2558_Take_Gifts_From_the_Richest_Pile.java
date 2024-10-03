package com.takeGiftsFromtheRichestPile;
import java.util.*;

/*
You are given an integer array gifts denoting the number of gifts in various piles. 
Every second, you do the following:

	. Choose the pile with the maximum number of gifts.
	. If there is more than one pile with the maximum number of gifts, choose any.
	. Leave behind the floor of the square root of the number of gifts in the pile. 
		Take the rest of the gifts.

Return the number of gifts remaining after k seconds.
*/

public class E2558_Take_Gifts_From_the_Richest_Pile {

	public static void main(String[] args) {
		E2558_Take_Gifts_From_the_Richest_Pile solution = new E2558_Take_Gifts_From_the_Richest_Pile();
		int[] input = {25,64,9,4,100};
		int k = 4;
		long output = solution.pickGifts(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public long pickGifts(int[] gifts, int k) {
        // Create a max heap to always pick the pile with the maximum gifts
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all the piles of gifts to the max heap
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        // Perform the operation for k seconds
        for (int i = 0; i < k; i++) {
            // Get the largest pile
            int largestPile = maxHeap.poll();
            // Calculate the remaining gifts after taking the square root
            int remainingGifts = (int) Math.floor(Math.sqrt(largestPile));
            // Add the remaining gifts back to the heap
            maxHeap.add(remainingGifts);
        }

        // Sum up all the remaining gifts
        long totalRemainingGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalRemainingGifts += maxHeap.poll();
        }

        return totalRemainingGifts;
    }

}
