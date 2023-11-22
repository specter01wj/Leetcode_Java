package com.longestSubsequenceWithLimitedSum;
import java.util.*;

/*
You are given an integer array nums of length n, and an integer array queries of length m.

Return an array answer of length m where answer[i] is the maximum size of a subsequence 
that you can take from nums such that the sum of its elements is less than or equal to 
queries[i].

A subsequence is an array that can be derived from another array by deleting some or 
no elements without changing the order of the remaining elements.
*/

public class E2389_Longest_Subsequence_With_Limited_Sum {

	public static void main(String[] args) {
		int[] input = {4,5,2,1}, queries = {3,10,21};
		int[] output = answerQueries(input, queries);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. Sort input nums, since we care the sum and doesn't care the order.
	2. Calculate the prefix sum of A, since we want to know the accumulate sum.
	3. Binary search each query q in query, and the index is the result.
	4. return result res.
    */
	
	/*
     * @param nums: a list of integers
     * @param queries: a list of integers
     * @return: an array answer of length m
     */
	public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length, m = queries.length, res[] = new int[m];
        for (int i = 1; i < n; ++i) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < m; ++i) {
            int j = Arrays.binarySearch(nums, queries[i]);
            res[i] = Math.abs(j + 1);
        }
        return res;
    }

}
