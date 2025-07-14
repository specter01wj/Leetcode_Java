package com.maxConsecutiveOnesIII;
import java.util.*;

/*
Given a binary array nums and an integer k, return the maximum number 
of consecutive 1's in the array if you can flip at most k 0's.
*/

public class M1004_Max_Consecutive_Ones_III {

	public static void main(String[] args) {
		M1004_Max_Consecutive_Ones_III solution = new M1004_Max_Consecutive_Ones_III();
		int[] input = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		int output = solution.longestOnes(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}
