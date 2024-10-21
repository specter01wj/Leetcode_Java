package com.findtheMaximumDivisibilityScore;
import java.util.*;

/*
You are given two integer arrays nums and divisors.

The divisibility score of divisors[i] is the number of indices j such 
that nums[j] is divisible by divisors[i].

Return the integer divisors[i] with the maximum divisibility score. 
If multiple integers have the maximum score, return the smallest one.
*/

public class E2644_Find_the_Maximum_Divisibility_Score {

	public static void main(String[] args) {
		E2644_Find_the_Maximum_Divisibility_Score solution = new E2644_Find_the_Maximum_Divisibility_Score();
		int[] input = {2,9,15,50}, divisors = {5,3,7,2};
		int output = solution.maxDivScore(input, divisors);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. initialize maxScore to -1 and resultDivisor to the maximum possible integer value. 
    	This ensures that any divisor will update these values the first time.
	2. For each divisor, count how many numbers in nums are divisible by that divisor.
	3. If the current score is greater than maxScore, or if it's equal to maxScore but 
		the divisor is smaller, update maxScore and resultDivisor.
	4. Finally, return the resultDivisor.
    */
	
	/*
     * @param nums: a list of integers
     * @param divisors: a list of integers
     * @return: the integer divisors[i] with the maximum divisibility score
     */
	public int maxDivScore(int[] nums, int[] divisors) {
        int maxScore = -1;
        int resultDivisor = Integer.MAX_VALUE;

        // Iterate through each divisor
        for (int divisor : divisors) {
            int score = 0;

            // Calculate the divisibility score for the current divisor
            for (int num : nums) {
                if (num % divisor == 0) {
                    score++;
                }
            }

            // Update the result if the current divisor has a higher score,
            // or if the score is the same but the divisor is smaller
            if (score > maxScore || (score == maxScore && divisor < resultDivisor)) {
                maxScore = score;
                resultDivisor = divisor;
            }
        }

        return resultDivisor;
    }

}
