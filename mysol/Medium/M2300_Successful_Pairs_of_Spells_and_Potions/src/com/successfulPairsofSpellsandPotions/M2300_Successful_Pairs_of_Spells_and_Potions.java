package com.successfulPairsofSpellsandPotions;
import java.util.*;

/*
You are given two positive integer arrays spells and potions, 
of length n and m respectively, where spells[i] represents the 
strength of the ith spell and potions[j] represents the strength 
of the jth potion.

You are also given an integer success. A spell and potion pair 
is considered successful if the product of their strengths is 
at least success.

Return an integer array pairs of length n where pairs[i] is 
the number of potions that will form a successful pair 
with the ith spell.
*/

public class M2300_Successful_Pairs_of_Spells_and_Potions {

	public static void main(String[] args) {
		int[] spells = {5,1,3};
		int[] potions = {1,2,3,4,5};
		int success = 7;
		int[] output = successfulPairs(spells, potions, success);
        System.out.println("input: " + Arrays.toString(spells) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    BST
    */
	
	/*
     * @param spells: a list of integers
     * @param potions: a list of integers
     * @param success: an integer
     * @return: an integer array pairs of length n
     */
	public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Sort the potions array
        Arrays.sort(potions);

        int n = spells.length;
        int[] pairs = new int[n];

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = potions.length - 1;

            // Apply binary search for each spell
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long)spells[i] * potions[mid] < success) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // Count the number of successful pairs for the current spell
            pairs[i] = potions.length - left;
        }

        return pairs;
    }

}
