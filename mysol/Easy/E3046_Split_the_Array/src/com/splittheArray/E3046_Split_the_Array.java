package com.splittheArray;
import java.util.*;

/*
You are given an integer array nums of even length. 
You have to split the array into two parts nums1 and nums2 such that:

	. nums1.length == nums2.length == nums.length / 2.
	. nums1 should contain distinct elements.
	. nums2 should also contain distinct elements.

Return true if it is possible to split the array, and false otherwise.
*/

public class E3046_Split_the_Array {

	public static void main(String[] args) {
		E3046_Split_the_Array solution = new E3046_Split_the_Array();
		int[] input = {1,1,2,2,3,4};
		boolean output = solution.isPossibleToSplit(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. HashMap for Frequency Count:
		. A HashMap is used to store the frequency of each number in the array. 
			This helps us efficiently count how many times each number appears.
	2. Check Frequency Constraint:
		. After building the frequency map, we iterate over its values to ensure 
			no number appears more than twice. If any number has a count greater 
			than 2, splitting into two groups with distinct elements is not possible.
	3. Return Result:
		. If all numbers appear at most twice, the array can be split into two 
			parts with distinct elements. Otherwise, the function returns false.
    */
	
	/*
     * @param nums: a list of integers
     * @return: true if it is possible to split the array, and false otherwise
     */
	public boolean isPossibleToSplit(int[] nums) {
        // Create a HashMap to count the occurrences of each number
        HashMap<Integer, Integer> count = new HashMap<>();

        // Count the frequency of each number in the array
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        // Check if any number appears more than twice
        for (int val : count.values()) {
            if (val > 2) {
                return false; // If a number appears more than twice, splitting is not possible
            }
        }
        
        // If all numbers appear at most twice, splitting is possible
        return true;
    }

}
