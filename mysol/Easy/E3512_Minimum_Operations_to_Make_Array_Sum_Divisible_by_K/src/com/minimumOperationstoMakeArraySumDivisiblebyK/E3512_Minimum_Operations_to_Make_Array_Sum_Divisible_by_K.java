package com.minimumOperationstoMakeArraySumDivisiblebyK;
import java.util.*;

/*
You are given an integer array nums and an integer k. 
You can perform the following operation any number of times:

	. Select an index i and replace nums[i] with nums[i] - 1.

Return the minimum number of operations required to make the sum 
of the array divisible by k.
*/

public class E3512_Minimum_Operations_to_Make_Array_Sum_Divisible_by_K {

	public static void main(String[] args) {
		E3512_Minimum_Operations_to_Make_Array_Sum_Divisible_by_K solution = new E3512_Minimum_Operations_to_Make_Array_Sum_Divisible_by_K();
		int[] input = {3,9,7};
		int k = 5;
		int output = solution.minOperations(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    sum(nums) % k
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: the minimum number of operations
     */
	public int minOperations(int[] nums, int k) {
		long sum = 0;
		
		for (int num : nums) {
			sum += num;
		}
		
		int remainder = (int)(sum % k);
		
		return remainder == 0 ? 0 : remainder;
	}

}
