package com.maxConsecutiveOnesIII;
import java.util.*;

/*
Given a binary array nums and an integer k, return the maximum 
number of consecutive 1's in the array if you can flip at most k 0's.
*/

public class M1004_Max_Consecutive_Ones_III {

	public static void main(String[] args) {
		int[] input = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		int output = longestOnes(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	
	public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxOnes = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            // If the current element is 0, increment the zero count
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If zero count exceeds k, shrink the window from the left
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum size of the window
            maxOnes = Math.max(maxOnes, right - left + 1);
            right++;
        }

        return maxOnes;
    }

}
