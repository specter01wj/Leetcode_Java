package com.numberofGoodPairs;
import java.util.*;

/*
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.


Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.

Example 3:

Input: nums = [1,2,3]
Output: 0
*/

public class E1512_Number_of_Good_Pairs {

	public static void main(String[] args) {
		int[] input = {1,2,3,1,1,3};
		int output = numIdenticalPairs(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int numIdenticalPairs(int[] nums) {
        int res = 0, count[] = new int[101];
        for (int item : nums) {
        	res += count[item]++;
        }
        
        return res;
    }

}
