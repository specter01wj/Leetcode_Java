package com.makeArrayZerobySubtractingEqualAmounts;
import java.util.*;

/*
You are given a non-negative integer array nums. In one operation, you must:

. Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
. Subtract x from every positive element in nums.

Return the minimum number of operations to make every element in nums equal to 0.


Example 1:

Input: nums = [1,5,0,3,5]
Output: 3
Explanation:
In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].

Example 2:

Input: nums = [0]
Output: 0
Explanation: Each element in nums is already 0 so no operations are needed.
*/

public class E2357_Make_Array_Zero_by_Subtracting_Equal_Amounts {

	public static void main(String[] args) {
		int[] input = {1,5,0,3,5};
		int output = minimumOperations(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int minimumOperations(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (num > 0) {
				set.add(num);
			}
		}
		
		return set.size();
	}

}
