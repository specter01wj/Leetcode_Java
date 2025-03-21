package com.finalArrayStateAfterKMultiplicationOperationsI;
import java.util.*;

/*
You are given an integer array nums, an integer k, and an integer multiplier.

You need to perform k operations on nums. In each operation:

	. Find the minimum value x in nums. If there are multiple occurrences of 
		the minimum value, select the one that appears first.
	. Replace the selected minimum value x with x * multiplier.

Return an integer array denoting the final state of nums after performing all k operations.
*/

public class E3264_Final_Array_State_After_K_Multiplication_Operations_I {

	public static void main(String[] args) {
		E3264_Final_Array_State_After_K_Multiplication_Operations_I solution = new E3264_Final_Array_State_After_K_Multiplication_Operations_I();
		int[] input = {2,1,3,5,6};
		int k = 5, multiplier = 2;
		int[] inputCopy = Arrays.copyOf(input, input.length);
		int[] output = solution.getFinalState(inputCopy, k, multiplier);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. Loop k times.
	2. In each iteration, find the first occurrence of the minimum value in the array.
	3. Multiply that value by multiplier and update the array.
	4. Return the final array state.
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @param multiplier: an integer
     * @return: an integer array denoting the final state of nums after performing all k operations
     */
	public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int minIndex = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            nums[minIndex] *= multiplier;
        }
        return nums;
    }

}
