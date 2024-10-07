package com.findtheArrayConcatenationValue;
import java.util.*;

/*
You are given a 0-indexed integer array nums.

The concatenation of two numbers is the number formed by concatenating 
their numerals.

	. For example, the concatenation of 15, 49 is 1549.

The concatenation value of nums is initially equal to 0. 
Perform this operation until nums becomes empty:

	. If there exists more than one number in nums, pick the first element 
		and last element in nums respectively and add the value of their 
		concatenation to the concatenation value of nums, then delete the 
		first and last element from nums.
	. If one element exists, add its value to the concatenation value of 
		nums, then delete it.

Return the concatenation value of the nums.
*/

public class E2562_Find_the_Array_Concatenation_Value {

	public static void main(String[] args) {
		E2562_Find_the_Array_Concatenation_Value solution = new E2562_Find_the_Array_Concatenation_Value();
		int[] input = {7,52,2,4};
		long output = solution.findTheArrayConcVal(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public long findTheArrayConcVal(int[] nums) {
        long concatenationValue = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            if (left == right) {
                concatenationValue += nums[left];
                break;
            } else {
                String concat = Integer.toString(nums[left]) + Integer.toString(nums[right]);
                concatenationValue += Long.parseLong(concat);
            }
            left++;
            right--;
        }
        
        return concatenationValue;
    }

}
