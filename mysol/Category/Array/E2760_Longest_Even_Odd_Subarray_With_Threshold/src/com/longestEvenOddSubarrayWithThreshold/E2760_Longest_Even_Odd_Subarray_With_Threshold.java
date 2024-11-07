package com.longestEvenOddSubarrayWithThreshold;
import java.util.*;

/*
You are given a 0-indexed integer array nums and an integer threshold.

Find the length of the longest subarray of nums starting at index l and 
ending at index r (0 <= l <= r < nums.length) that satisfies the following 
conditions:

	. nums[l] % 2 == 0
	. For all indices i in the range [l, r - 1], nums[i] % 2 != nums[i + 1] % 2
	. For all indices i in the range [l, r], nums[i] <= threshold

Return an integer denoting the length of the longest such subarray.

Note: A subarray is a contiguous non-empty sequence of elements within an array.
*/

public class E2760_Longest_Even_Odd_Subarray_With_Threshold {

	public static void main(String[] args) {
		int[] input = {3,0,1,1,9,7};
		int output = countGoodTriplets(input, 7, 2, 3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	

}
