package com.findifDigitGameCanBeWon;
import java.util.*;

/*
You are given an array of positive integers nums.

Alice and Bob are playing a game. In the game, Alice can choose 
either all single-digit numbers or all double-digit numbers from 
nums, and the rest of the numbers are given to Bob. Alice wins 
if the sum of her numbers is strictly greater than the sum of 
Bob's numbers.

Return true if Alice can win this game, otherwise, return false.
*/

public class E3232_Find_if_Digit_Game_Can_Be_Won {

	public static void main(String[] args) {
		E3232_Find_if_Digit_Game_Can_Be_Won solution = new E3232_Find_if_Digit_Game_Can_Be_Won();
		int[] input = {1,2,3,4,5,14};
		boolean output = solution.canAliceWin(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public boolean canAliceWin(int[] nums) {
        int singleDigitSum = 0, doubleDigitSum = 0;

        // Calculate the sum of single-digit and double-digit numbers
        for (int num : nums) {
            if (num < 10) {
                singleDigitSum += num;
            } else if (num < 100) {
                doubleDigitSum += num;
            }
        }

        // Calculate Bob's sums in each case
        int bobSumWhenAliceTakesSingles = doubleDigitSum;
        int bobSumWhenAliceTakesDoubles = singleDigitSum;

        // Check if Alice can win in either case
        return singleDigitSum > bobSumWhenAliceTakesSingles || doubleDigitSum > bobSumWhenAliceTakesDoubles;
    }

}
