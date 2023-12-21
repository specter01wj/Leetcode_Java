package com.longestSubarrayof1sAfterDeletingOneElement;
import java.util.*;

/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 
1's in the resulting array. Return 0 if there is no such subarray.
*/

public class M1493_Longest_Subarray_of_1s_After_Deleting_One_Element {

	public static void main(String[] args) {
		int[] input = {0,1,1,1,0,1,1,0,1};
		int output = longestSubarray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Sliding Window
    */
	
	/*
     * @param nums: a list of integers
     * @return: the size of the longest non-empty subarray containing only 1's in the resulting array
     */
	public static int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLength = 0;

        while (right < nums.length) {
            // If the current element is 0, increment the zero count
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If zero count exceeds 1, shrink the window from the left
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum length of the window, minus 1 if we include a zero
            maxLength = Math.max(maxLength, right - left);

            right++;
        }

        // Return the maximum length found
        return maxLength;
    }

}
