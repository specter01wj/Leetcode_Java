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
		E2760_Longest_Even_Odd_Subarray_With_Threshold solution = new E2760_Longest_Even_Odd_Subarray_With_Threshold();
		int[] input = {3,2,5,4};
		int threshold = 5;
		int output = solution.longestAlternatingSubarray(input, threshold);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Outer Loop to Start a New Subarray:
		. For each index i, we check if nums[i] is an even number and within the threshold.
		. If it meets these conditions, we start a new subarray with currentLength = 1.
	2. Inner Loop to Expand the Subarray:
		. We expand the subarray by iterating through nums starting from i + 1.
		. We alternate the parity (isEven) and ensure each nums[j] is within the threshold.
		. If nums[j] doesn’t satisfy alternating parity or exceeds the threshold, 
			we break out of the inner loop.
	3. Update Maximum Length:
		. We update maxLength with the maximum of maxLength and currentLength after each subarray.
	4. Return the Result:
		. After iterating through nums, maxLength holds the length of the longest alternating 
			subarray that satisfies the conditions.
    */
	
	/*
     * @param nums: a list of integers
     * @param threshold: an integer
     * @return: an integer denoting the length of the longest such subarray
     */
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
