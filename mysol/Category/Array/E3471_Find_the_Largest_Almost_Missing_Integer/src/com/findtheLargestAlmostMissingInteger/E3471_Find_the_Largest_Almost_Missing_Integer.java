package com.findtheLargestAlmostMissingInteger;
import java.util.*;

/*
You are given an integer array nums and an integer k.

An integer x is almost missing from nums if x appears in exactly 
one subarray of size k within nums.

Return the largest almost missing integer from nums. If no such 
integer exists, return -1.

A subarray is a contiguous sequence of elements within an array.
*/

public class E3471_Find_the_Largest_Almost_Missing_Integer {

	public static void main(String[] args) {
		E3471_Find_the_Largest_Almost_Missing_Integer solution = new E3471_Find_the_Largest_Almost_Missing_Integer();
		int[] input = {3,9,2,1,7};
		int k = 3;
		int output = solution.largestInteger(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Use a Map<Integer, Integer> to count the number of subarrays each number appears in.
	2. For each sliding window of size k, use a Set to avoid double-counting the same number in one window.
	3. Iterate through the map, and find the maximum number that appears in exactly one window.
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: the largest almost missing integer from nums
     */
	public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i <= n - k; i++) {
            Set<Integer> windowSet = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                windowSet.add(nums[j]);
            }
            for (int num : windowSet) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                max = Math.max(max, entry.getKey());
            }
        }

        return max;
    }

}
