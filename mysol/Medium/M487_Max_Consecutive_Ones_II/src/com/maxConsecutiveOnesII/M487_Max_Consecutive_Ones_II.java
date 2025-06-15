package com.maxConsecutiveOnesII;
import java.util.*;

/*
Given a binary array nums, return the maximum number of consecutive 1's 
in the array if you can flip at most one 0.
*/

public class M487_Max_Consecutive_Ones_II {

	public static void main(String[] args) {
		M487_Max_Consecutive_Ones_II solution = new M487_Max_Consecutive_Ones_II();
		int[] input = {1,0,1,1,0};
		int output = solution.findMaxConsecutiveOnes(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Use two pointers: left and right to form a window.
	2. Allow at most one 0 in the window (zeroCount <= 1).
	3. If more than one 0 is in the window:
		. Shrink the window from the left until zeroCount <= 1.
	4. Update the maximum window size during each step.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the maximum number of consecutive 1's in the array
     */
	public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int left = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

}
