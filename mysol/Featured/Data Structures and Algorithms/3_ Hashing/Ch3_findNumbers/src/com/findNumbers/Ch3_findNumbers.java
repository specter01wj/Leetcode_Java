package com.findNumbers;
import java.util.*;

/*
Example 3: Given an integer array nums, find all the numbers x in nums 
that satisfy the following: x + 1 is not in nums, and x - 1 is not in nums.

If a valid number x appears multiple times, you only need to include it in the answer once.
*/

public class Ch3_findNumbers {

	public static void main(String[] args) {
		Ch3_findNumbers solution = new Ch3_findNumbers();
		int[] input = {1, 2, 4, 5, 7, 7, 9};
		List<Integer> output = solution.findNumbers(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashSet
    */
	
	/*
     * @param nums: a list of integers
     * @return: find all the numbers x in nums
     */
	public List<Integer> findNumbers(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        // Store all numbers in a HashSet for fast lookup
        for (int num : nums) {
            numSet.add(num);
        }

        // Check each number if it satisfies the condition
        for (int num : nums) {
            if (!numSet.contains(num - 1) && !numSet.contains(num + 1)) {
                result.add(num);
            }
        }

        return result;
    }

}
