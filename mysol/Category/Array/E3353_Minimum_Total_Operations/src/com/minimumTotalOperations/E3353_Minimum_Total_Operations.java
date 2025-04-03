package com.minimumTotalOperations;
import java.util.*;

/*
Given an array of integers nums, you can perform any number of 
operations on this array.

In each operation, you can:

	. Choose a prefix of the array.
	. Choose an integer k (which can be negative) and add k to each element in the chosen prefix.

A prefix of an array is a subarray that starts from the beginning of 
the array and extends to any point within it.

Return the minimum number of operations required to make all elements in arr equal.
*/

public class E3353_Minimum_Total_Operations {
	
	public static void main(String[] args) {
		E3353_Minimum_Total_Operations solution = new E3353_Minimum_Total_Operations();
		int[] input = {1,4,2};
		int output = solution.minOperations(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. int operations = 0:
		. Stores the count of operations needed to make all elements equal.
	2. Traverse the array from right to left (index i from n - 2 to 0):
		. This ensures we always compare each element with the one that follows it, simulating working backwards from the goal.
	3. Compare nums[i] and nums[i + 1]:
		. If they are not equal, it means we need to perform an operation to bring nums[i] in line with nums[i + 1].
		. This simulates choosing a prefix up to index i and adding a value to match the next number.
	4. Increment operations when a difference is found:
		. Each difference between adjacent values indicates one required operation.
		. This is the minimal number of operations due to the allowed prefix operation rule.
	5. Return operations:
		. The total number of value changes from right to left equals the minimum number of operations needed.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the minimum number of operations required to make all elements in arr equal
     */
	public int minOperations(int[] nums) {
        int operations = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                operations++;
            }
        }
        return operations;
    }

}
