package com.findSubarraysWithEqualSum;
import java.util.*;

/*
Given a 0-indexed integer array nums, determine whether 
there exist two subarrays of length 2 with equal sum. 
Note that the two subarrays must begin at different indices.

Return true if these subarrays exist, and false otherwise.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

public class E2395_Find_Subarrays_With_Equal_Sum {

	public static void main(String[] args) {
		int[] input = {4,2,4};
		boolean output = findSubarrays(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    use HashSet
    */
	
	/*
     * @param nums: a list of integers
     * @return: true if these subarrays exist, and false otherwise
     */
	public static boolean findSubarrays(int[] nums) {
		HashSet<Integer> seenSums = new HashSet<>();
		
		for (int i = 0; i < nums.length - 1; i++) {
			int sum = nums[i] + nums[i + 1];
			if (seenSums.contains(sum)) {
				return true;
			}
			seenSums.add(sum);
		}
		
		return false;
	}

}
