package com.transformArraybyParity;
import java.util.*;

/*
You are given an integer array nums. Transform nums by performing 
the following operations in the exact order specified:

1. Replace each even number with 0.
2. Replace each odd numbers with 1.
3. Sort the modified array in non-decreasing order.

Return the resulting array after performing these operations.
*/

public class E3467_Transform_Array_by_Parity {

	public static void main(String[] args) {
		E3467_Transform_Array_by_Parity solution = new E3467_Transform_Array_by_Parity();
		int[] input = {4,3,2,1};
		int[] inputCopy = Arrays.copyOf(input, input.length);
		int[] output = solution.transformArray(inputCopy);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] transformArray(int[] nums) {
        // Step 1: Transform each number based on parity
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;  // 0 for even, 1 for odd
        }

        // Step 2: Sort the modified array
        Arrays.sort(nums);

        return nums;
    }

}
