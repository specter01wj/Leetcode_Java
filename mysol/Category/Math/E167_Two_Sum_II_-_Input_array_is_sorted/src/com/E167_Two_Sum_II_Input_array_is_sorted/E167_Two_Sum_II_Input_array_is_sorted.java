package com.E167_Two_Sum_II_Input_array_is_sorted;

import java.util.*;

/*Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up 
to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use 
the same element twice.

Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.*/

public class E167_Two_Sum_II_Input_array_is_sorted {

	public static void main(String[] args) {
		int[] input = {2,7,11,15};
		int target = 9;
        int[] output = twoSum(input, target);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    利用双指针的做法。
	不断移动左指针，调整右指针的位置，直到相等即可。
    */
	
	/*
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
	public static int[] twoSum(int[] numbers, int target) {
		if(numbers == null || numbers.length < 2) {
			return new int[0];
		}
		
		for(int low = 0, high = numbers.length - 1; low < high; high--) {
			while(low < high && numbers[low] + numbers[high] < target) {
				low++;
			}
			if(low != high && numbers[low] + numbers[high] == target) {
				return new int[] {low + 1, high + 1};
			}
		}
		
		return new int[0];
	}

}
