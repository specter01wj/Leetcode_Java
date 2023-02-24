package com.countElementsWithStrictlySmallerandGreaterElements;
import java.util.*;

/*
Given an integer array nums, return the number of elements that have 
both a strictly smaller and a strictly greater element appear in nums.


Example 1:

Input: nums = [11,7,2,15]
Output: 2
Explanation: The element 7 has the element 2 strictly smaller than it and the element 11 strictly greater than it.
Element 11 has element 7 strictly smaller than it and element 15 strictly greater than it.
In total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.

Example 2:

Input: nums = [-3,3,3,90]
Output: 2
Explanation: The element 3 has the element -3 strictly smaller than it and the element 90 strictly greater than it.
Since there are two elements with the value 3, in total there are 2 elements having both a strictly smaller and a 
strictly greater element appear in nums.
*/

public class E2148_Count_Elements_With_Strictly_Smaller_and_Greater_Elements {

	public static void main(String[] args) {
		int[] input = {11,7,2,15};
		int output = countElements(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > min && nums[i] < max) {
                count++;
            }
        }
        return count;
    }

}
