package com.applyOperationstoanArray;
import java.util.*;

/*
You are given a 0-indexed array nums of size n consisting of non-negative integers.

You need to apply n - 1 operations to this array where, in the ith operation 
(0-indexed), you will apply the following on the ith element of nums:

	. If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set 
		nums[i + 1] to 0. Otherwise, you skip this operation.

After performing all the operations, shift all the 0's to the end of the array.

	. For example, the array [1,0,2,0,0,1] after shifting all its 0's to the end, 
		is [1,2,1,0,0,0].

Return the resulting array.

Note that the operations are applied sequentially, not all at once.
*/

public class E2460_Apply_Operations_to_an_Array {

	public static void main(String[] args) {
		E2460_Apply_Operations_to_an_Array solution = new E2460_Apply_Operations_to_an_Array();
		int[] input = {1,2,2,1,1,0};
		int[] inputCopy = Arrays.copyOf(input, input.length);
		int[] output = solution.applyOperations(inputCopy);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. Apply operations: Iterate through the array and, if consecutive elements 
    	are the same, double the first and set the second to 0.
	2. Shift zeros: Create a new array and place non-zero elements first, 
		followed by zeros at the end.
	3. Return the result array.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the resulting array
     */
	public int[] applyOperations(int[] nums) {
        int n = nums.length;

        // Apply the operations on the array
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Shift all 0s to the end of the array
        int[] result = new int[n];
        int index = 0;
        
        // First, place non-zero elements in the result array
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                result[index++] = nums[i];
            }
        }

        // Return the result with zeroes shifted to the end
        return result;
    }

}
