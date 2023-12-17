package com.increasingTripletSubsequence;
import java.util.*;

/*
Given an integer array nums, return true if there exists a triple of 
indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. 
If no such indices exists, return false.
*/

public class M334_Increasing_Triplet_Subsequence {

	public static void main(String[] args) {
		int[] input = {2,1,5,0,4,6};
		boolean output = increasingTriplet(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        // Initialize the first and second numbers to the maximum possible value
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                // Update the lowest number found so far
                first = num;
            } else if (num <= second) {
                // Update the second lowest number
                second = num;
            } else {
                // Found a number greater than both first and second
                return true;
            }
        }

        return false;
    }

}
