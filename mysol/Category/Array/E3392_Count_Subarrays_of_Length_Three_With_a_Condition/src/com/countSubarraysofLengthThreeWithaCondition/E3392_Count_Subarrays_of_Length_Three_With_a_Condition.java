package com.countSubarraysofLengthThreeWithaCondition;
import java.util.*;

/*
Given an integer array nums, return the number of subarrays of length 3 
such that the sum of the first and third numbers equals exactly half of 
the second number.
*/

public class E3392_Count_Subarrays_of_Length_Three_With_a_Condition {

	public static void main(String[] args) {
		int[] input = {3,0,1,1,9,7};
		int output = countGoodTriplets(input, 7, 2, 3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int countSubarrays(int[] nums) {
		int count = 0;
		
		for (int i = 1; i < nums.length - 1; i++) {
			int first = nums[i - 1];
			int mid = nums[i];
			int third = nums[i + 1];
			
			// Check if first + third == mid / 2 (make sure mid is even)
			if ((first + third) * 2 == mid) {
				count++;
			}
		}
		
		return count;
	}

}
