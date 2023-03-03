package com.countEqualandDivisiblePairsinanArray;
import java.util.*;

/*
Given a 0-indexed integer array nums of length n and an integer k, 
return the number of pairs (i, j) where 0 <= i < j < n, 
such that nums[i] == nums[j] and (i * j) is divisible by k.


Example 1:

Input: nums = [3,1,2,2,2,1,3], k = 2
Output: 4
Explanation:
There are 4 pairs that meet all the requirements:
- nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
- nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
- nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
- nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.

Example 2:

Input: nums = [1,2,3,4], k = 1
Output: 0
Explanation: Since no value in nums is repeated, there are no pairs (i,j) 
that meet all the requirements.
*/

public class E2176_Count_Equal_and_Divisible_Pairs_in_an_Array {

	public static void main(String[] args) {
		int[] input = {3,1,2,2,2,1,3};
		int k = 2;
		int output = countPairs(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            indices.computeIfAbsent(nums[i], l -> new ArrayList<>()).add(i);
        } 
        int cnt = 0;
        for (List<Integer> ind : indices.values()) {
            for (int i = 0; i < ind.size(); ++i) {
                for (int j = 0; j < i; ++j) {
                    if (ind.get(i) * ind.get(j) % k == 0) {
                        ++cnt;
                    }
                }
            }
        }
        return cnt; 
    }

}
