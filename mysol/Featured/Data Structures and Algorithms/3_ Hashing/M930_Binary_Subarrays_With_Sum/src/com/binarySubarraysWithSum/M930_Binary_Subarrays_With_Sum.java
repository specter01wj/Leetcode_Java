package com.binarySubarraysWithSum;
import java.util.*;

/*
Given a binary array nums and an integer goal, 
return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.
*/

public class M930_Binary_Subarrays_With_Sum {

	public static void main(String[] args) {
		M930_Binary_Subarrays_With_Sum solution = new M930_Binary_Subarrays_With_Sum();
		int[] input = {1,0,1,0,1};
		int goal = 2;
		int output = solution.numSubarraysWithSum(input, goal);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param nums: a list of integers
     * @return: the largest integer
     */
	public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // for subarrays starting from index 0

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            // If (sum - goal) has occurred before, it contributes to valid subarrays
            count += prefixSumCount.getOrDefault(sum - goal, 0);

            // Update frequency of current prefix sum
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
