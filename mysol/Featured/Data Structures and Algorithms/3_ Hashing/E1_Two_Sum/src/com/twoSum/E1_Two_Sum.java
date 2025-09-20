package com.twoSum;
import java.util.*;

/*
Given an array of integers nums and an integer target, return indices of 
the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you 
may not use the same element twice.

You can return the answer in any order.
*/

public class E1_Two_Sum {

	public static void main(String[] args) {
		E1_Two_Sum solution = new E1_Two_Sum();
		int[] input = {2,7,11,15};
		int target = 9;
		int[] output = solution.twoSum(input, target);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] twoSum(int[] nums, int target) {
        // Map to store number and its index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store current number and its index
            map.put(nums[i], i);
        }

        // If no solution found (though the problem guarantees one)
        return new int[] {};
    }

}
