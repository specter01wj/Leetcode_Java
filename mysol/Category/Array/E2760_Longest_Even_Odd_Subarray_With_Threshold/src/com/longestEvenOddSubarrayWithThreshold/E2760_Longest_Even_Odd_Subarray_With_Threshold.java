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
		int[] input = {3,2,5,4};
		int threshold = 5;
		int output = longestAlternatingSubarray(input, threshold);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLength = 0;
        int i = 0;

        while (i < nums.length) {
            // Only start counting if we find an even number within the threshold
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                int currentLength = 1;
                boolean expectOdd = true;

                // Expand the subarray by checking alternating parity and threshold condition
                for (int j = i + 1; j < nums.length && nums[j] <= threshold; j++) {
                    if ((nums[j] % 2 == 0) == expectOdd) {
                        break;
                    }
                    currentLength++;
                    expectOdd = !expectOdd;  // Alternate between even and odd expectation
                }

                maxLength = Math.max(maxLength, currentLength);
            }
            i++;
        }

        return maxLength;
    }

}
