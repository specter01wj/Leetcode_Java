package com.mostFrequentNumberFollowingKeyInanArray;
import java.util.*;

/*
You are given a 0-indexed integer array nums. You are also given an integer key, 
which is present in nums.

For every unique integer target in nums, count the number of times target 
immediately follows an occurrence of key in nums. In other words, 
count the number of indices i such that:

	.0 <= i <= nums.length - 2,
	.nums[i] == key and,
	.nums[i + 1] == target.

Return the target with the maximum count. The test cases will be generated 
such that the target with maximum count is unique.


Example 1:

Input: nums = [1,100,200,1,100], key = 1
Output: 100
Explanation: For target = 100, there are 2 occurrences at indices 1 and 4 which 
follow an occurrence of key.
No other integers follow an occurrence of key, so we return 100.

Example 2:

Input: nums = [2,2,2,2,3], key = 2
Output: 2
Explanation: For target = 2, there are 3 occurrences at indices 1, 2, and 3 which 
follow an occurrence of key.
For target = 3, there is only one occurrence at index 4 which follows an occurrence of key.
target = 2 has the maximum number of occurrences following an occurrence of key, so we return 2.
*/

public class E2190_Most_Frequent_Number_Following_Key_In_an_Array {

	public static void main(String[] args) {
		int[] input = {1,100,200,1,100};
		int key = 1;
		int output = mostFrequent(input, key);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> freq = new HashMap<>();
        int mostFreq = -1;
        for (int i = 0, n = nums.length, max = 0; i + 1 < n; ++i) {
            if (nums[i] == key) {
                int candidate = nums[i + 1];
                freq.put(candidate, 1 + freq.getOrDefault(candidate, 0));
                if (freq.get(candidate) > max) {
                    max = freq.get(candidate);
                    mostFreq = candidate;
                }
            }
        }
        return mostFreq;
    }

}
