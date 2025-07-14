package com.findBestSubarray;
import java.util.*;

/*
Example 4: Given an integer array nums and an integer k, 
find the sum of the subarray with the largest sum whose length is k.
*/

public class Ch2_findBestSubarray {

	public static void main(String[] args) {
		Ch2_findBestSubarray solution = new Ch2_findBestSubarray();
		int[] input = {3,-1,4,12,-8,5,6};
		int k = 4;
		int output = solution.findBestSubarray(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int findBestSubarray(int[] nums, int k) {
	    int curr = 0;
	    for (int i = 0; i < k; i++) {
	        curr += nums[i];
	    }

	    int ans = curr;
	    for (int i = k; i < nums.length; i++) {
	        curr += nums[i] - nums[i - k];
	        ans = Math.max(ans, curr);
	    }

	    return ans;
	}

}
