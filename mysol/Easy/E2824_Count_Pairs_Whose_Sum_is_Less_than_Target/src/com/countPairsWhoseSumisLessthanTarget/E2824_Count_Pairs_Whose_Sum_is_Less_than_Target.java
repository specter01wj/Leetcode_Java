package com.countPairsWhoseSumisLessthanTarget;
import java.util.*;

/*
Given a 0-indexed integer array nums of length n and an integer 
target, return the number of pairs (i, j) where 0 <= i < j < n 
and nums[i] + nums[j] < target.
*/

public class E2824_Count_Pairs_Whose_Sum_is_Less_than_Target {

	public static void main(String[] args) {
		E2824_Count_Pairs_Whose_Sum_is_Less_than_Target solution = new E2824_Count_Pairs_Whose_Sum_is_Less_than_Target();
		List<Integer> input = List.of(-6, 2, 5, -2, -7, -1, 3);
		int target = -2;
		int output = solution.countPairs(input, target);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Outer Loop:
		. The outer loop iterates over the indices i from 0 to n - 1.
	2. Inner Loop:
		. The inner loop iterates over the indices j starting from i + 1 to n - 1.
		. This ensures that only pairs where i < j are considered.
	3. Check Pair Sum:
		. For each pair (i, j), check if nums.get(i) + nums.get(j) < target.
		. If the condition is met, increment count.
	4. Return Result:
		. After checking all pairs, return the count.
    */
	
	/*
     * @param nums: a list of integers
     * @param target: an integer
     * @return: the number of pairs (i, j)
     */
	public int countPairs(List<Integer> nums, int target) {
		int count = 0;
		int n = nums.size();
		
		// Iterate over all pairs (i, j) with 0 <= i < j < n
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums.get(i) + nums.get(j) < target) {
					count++;
				}
			}
		}
		
		return count;
	}

}
