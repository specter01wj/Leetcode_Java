package com.maxPairSuminanArray;
import java.util.*;

/*
You are given an integer array nums. You have to find the maximum 
sum of a pair of numbers from nums such that the largest digit in 
both numbers is equal.

For example, 2373 is made up of three distinct digits: 2, 3, and 7, 
where 7 is the largest among them.

Return the maximum sum or -1 if no such pair exists.
*/

public class E2815_Max_Pair_Sum_in_an_Array {

	public static void main(String[] args) {
		E2815_Max_Pair_Sum_in_an_Array solution = new E2815_Max_Pair_Sum_in_an_Array();
		int[] input = {2536,1613,3366,162};
		int output = solution.maxSum(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int maxSum(int[] nums) {
        // Map to store the maximum number for each largest digit
        HashMap<Integer, Integer> maxNumByDigit = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int largestDigit = getLargestDigit(num);

            if (maxNumByDigit.containsKey(largestDigit)) {
                // Calculate the pair sum
                int pairSum = maxNumByDigit.get(largestDigit) + num;
                maxSum = Math.max(maxSum, pairSum);
                // Update the maximum number for this largest digit
                maxNumByDigit.put(largestDigit, Math.max(maxNumByDigit.get(largestDigit), num));
            } else {
                // Store the number for this largest digit
                maxNumByDigit.put(largestDigit, num);
            }
        }

        return maxSum;
    }

    // Helper method to find the largest digit in a number
    private int getLargestDigit(int num) {
        int largest = 0;
        while (num > 0) {
            largest = Math.max(largest, num % 10);
            num /= 10;
        }
        return largest;
    }

}
