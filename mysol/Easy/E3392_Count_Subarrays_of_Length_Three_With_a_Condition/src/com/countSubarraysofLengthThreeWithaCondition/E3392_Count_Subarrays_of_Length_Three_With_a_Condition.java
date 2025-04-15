package com.countSubarraysofLengthThreeWithaCondition;
import java.util.*;

/*
Given an integer array nums, return the number of subarrays of length 3 
such that the sum of the first and third numbers equals exactly half of 
the second number.
*/

public class E3392_Count_Subarrays_of_Length_Three_With_a_Condition {

	public static void main(String[] args) {
		E3392_Count_Subarrays_of_Length_Three_With_a_Condition solution = new E3392_Count_Subarrays_of_Length_Three_With_a_Condition();
		int[] input = {1,2,1,4,1};
		int output = solution.countSubarrays(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    loop and slide
    */
	
	/*
     * @param nums: a list of integers
     * @return: the number of subarrays of length 3
     */
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
