package com.largestPerimeterTriangle;
import java.util.*;

/*
Given an integer array nums, return the largest perimeter of 
a triangle with a non-zero area, formed from three of these lengths. 
If it is impossible to form any triangle of a non-zero area, return 0.


Example 1:

Input: nums = [2,1,2]
Output: 5

Example 2:

Input: nums = [1,2,1]
Output: 0
*/

public class E976_Largest_Perimeter_Triangle {

	public static void main(String[] args) {
		int[] input = {2,1,2};
        int output = largestPerimeter(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int largestPerimeter(int[] nums) {
		Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; --i) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
	}

}
