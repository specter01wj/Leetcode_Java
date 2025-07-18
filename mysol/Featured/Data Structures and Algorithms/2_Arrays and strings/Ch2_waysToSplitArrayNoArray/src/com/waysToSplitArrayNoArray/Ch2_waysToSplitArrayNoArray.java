package com.waysToSplitArrayNoArray;
import java.util.*;

/*
Example 2: 2270. Number of Ways to Split Array

Given an integer array nums, find the number of ways to split 
the array into two parts so that the first section has a sum 
greater than or equal to the sum of the second section. 
The second section should have at least one number.
*/

public class Ch2_waysToSplitArrayNoArray {

	public static void main(String[] args) {
		Ch2_waysToSplitArrayNoArray solution = new Ch2_waysToSplitArrayNoArray();
		int[] input = {10,4,-8,7};
		int output = solution.waysToSplitArrayNoArray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Prefix sum
    */
	
	/*
     * @param nums: a list of integers
     * @return: the number of valid splits in nums
     */
	public int waysToSplitArrayNoArray(int[] nums) {
        int ans = 0;
        long leftSection = 0;
        long total = 0;
        
        for (int num: nums) {
            total += num;
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            leftSection += nums[i];
            long rightSection = total - leftSection;
            if (leftSection >= rightSection) {
                ans++;
            }
        }
        
        return ans;
    }

}
