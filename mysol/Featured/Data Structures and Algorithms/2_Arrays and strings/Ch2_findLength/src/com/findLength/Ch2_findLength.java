package com.findLength;
import java.util.*;

/*
Example 1: Given an array of positive integers nums and an integer k, 
find the length of the longest subarray whose sum is less than or equal to k. 
This is the problem we have been talking about above. 
We will now formally solve it.
*/

public class Ch2_findLength {

	public static void main(String[] args) {
		Ch2_findLength solution = new Ch2_findLength();
		int[] input = {3, 1, 2, 7, 4, 2, 1, 1, 5};
		int k = 8;
		int output = solution.findLength(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Sliding window
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: the length of the longest subarray
     */
	public int findLength(int[] nums, int k) {
		int left = 0, curr = 0, ans = 0;
		
		for (int right = 0; right < nums.length; right++) {
			curr += nums[right];
			
			while (curr > k) {
				curr -= nums[left];
				left++;
			}
			
			ans = Math.max(ans, right - left + 1);
		}
		
		return ans;
	}

}
