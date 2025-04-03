package com.adjacentIncreasingSubarraysDetectionI;
import java.util.*;

/*
Given an array nums of n integers and an integer k, determine whether 
there exist two adjacent subarrays of length k such that both subarrays 
are strictly increasing. Specifically, check if there are two subarrays 
starting at indices a and b (a < b), where:

	. Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
	. The subarrays must be adjacent, meaning b = a + k.

Return true if it is possible to find two such subarrays, and false otherwise.
*/

public class E3349_Adjacent_Increasing_Subarrays_Detection_I {

	public static void main(String[] args) {
		E3349_Adjacent_Increasing_Subarrays_Detection_I solution = new E3349_Adjacent_Increasing_Subarrays_Detection_I();
		List<Integer> input = List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
		int k = 3;
		boolean output = solution.hasIncreasingSubarrays(input, k);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. n < 2 * k: Not enough room for two adjacent subarrays.
	2. Iterate from i = 0 to n - 2k, since we need two subarrays of length k starting at i and i + k.
	3. We use a helper function isIncreasing to check if a subarray of length k starting at a specific index is strictly increasing.
	4. Return true as soon as we find a valid pair. Otherwise, return false.
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: true if it is possible to find two such subarrays, and false otherwise
     */
	public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) return false;

        for (int i = 0; i <= nums.size() - 2 * k; i++) {
            if (isIncreasing(nums, i, k) && isIncreasing(nums, i + k, k)) {
                return true;
            }
        }

        return false;
    }

    private boolean isIncreasing(List<Integer> nums, int start, int k) {
        for (int i = start + 1; i < start + k; i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

}
