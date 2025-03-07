package com.longestAlternatingSubarray;
import java.util.*;

/*
You are given a 0-indexed integer array nums. 
A subarray s of length m is called alternating if:

	. m is greater than 1.
	. s1 = s0 + 1.
	. The 0-indexed subarray s looks like [s0, s1, s0, s1,...,s(m-1) % 2]. 
		In other words, s1 - s0 = 1, s2 - s1 = -1, s3 - s2 = 1, s4 - s3 = -1, 
		and so on up to s[m - 1] - s[m - 2] = (-1)m.

Return the maximum length of all alternating subarrays present in nums or -1 
if no such subarray exists.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

public class E2765_Longest_Alternating_Subarray {

	public static void main(String[] args) {
		E2765_Longest_Alternating_Subarray solution = new E2765_Longest_Alternating_Subarray();
		int[] input = {2,3,4,3,4};
		int output = solution.alternatingSubarray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Initialize Variables:
		. maxLength: Keeps track of the longest alternating subarray length 
			found so far (initialized to -1 if no valid subarray is found).
		. currentLength: Tracks the length of the current alternating subarray 
			being built.
	2. Loop Through the Array:
		. For each element starting from index 1, we check if the current element 
			alternates with the previous element:
			. If currentLength is odd, expect a difference of +1.
			. If currentLength is even, expect a difference of -1.
		. If the difference matches, we increment currentLength.
		. If the difference does not match:
			. Check if the current element and previous element can start a 
				new alternating subarray (i.e., difference of +1), in which 
				case currentLength is set to 2.
			. Otherwise, reset currentLength to 1.
	3. Update maxLength:
		. Each time we find a longer alternating subarray, we update maxLength.
	4. Return Result:
		. If we found any valid alternating subarray (maxLength > 1), 
			return maxLength; otherwise, return -1.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the maximum length of all alternating subarrays
     */
	public int alternatingSubarray(int[] nums) {
        int maxLength = -1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            // Check if the current pair alternates according to the condition
            if (nums[i] - nums[i - 1] == ((currentLength % 2 == 1) ? 1 : -1)) {
                currentLength++;
            } else {
                // Reset currentLength to 2 if we find a new starting pair that alternates
                if (nums[i] - nums[i - 1] == 1) {
                    currentLength = 2;
                } else {
                    currentLength = 1;
                }
            }

            // Update maxLength if we found a longer alternating subarray
            if (currentLength > 1) {
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

}
