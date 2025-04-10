package com.transformedArray;
import java.util.*;

/*
You are given an integer array nums that represents a circular array. 
Your task is to create a new array result of the same size, following these rules:

For each index i (where 0 <= i < nums.length), perform the following independent actions:

	. If nums[i] > 0: Start at index i and move nums[i] steps to the right in the circular array. 
		Set result[i] to the value of the index where you land.
	. If nums[i] < 0: Start at index i and move abs(nums[i]) steps to the left in the circular array. 
		Set result[i] to the value of the index where you land.
	. If nums[i] == 0: Set result[i] to nums[i].

Return the new array result.
*/

public class E3379_Transformed_Array {

	public static void main(String[] args) {
		E3379_Transformed_Array solution = new E3379_Transformed_Array();
		int[] input = {3,-2,1,1};
		int[] output = solution.constructTransformedArray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. Initialize:
		. n is the length of the array.
		. Create a result[] array of the same size to store transformed values.
	2. Loop through each element:
		. For each index i, examine the value nums[i].
	3. Three cases:
		. Case 1: nums[i] == 0
			. Just copy: result[i] = 0.
		. Case 2: nums[i] > 0
			. Move nums[i] steps to the right.
			. Use modulo: (i + nums[i]) % n.
		. Case 3: nums[i] < 0
			. Move abs(nums[i]) steps to the left.
			. Use modulo: (i + nums[i]) % n.
			. Adjust if index becomes negative by adding n.
	4. Return:
		. Return the filled result[] array.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the new array result
     */
	public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int steps = nums[i];
            if (steps == 0) {
                result[i] = nums[i];
            } else {
                int newIndex = (i + steps) % n;
                // Ensure newIndex is within bounds for negative steps
                if (newIndex < 0) {
                    newIndex += n;
                }
                result[i] = nums[newIndex];
            }
        }
        
        return result;
    }

}
