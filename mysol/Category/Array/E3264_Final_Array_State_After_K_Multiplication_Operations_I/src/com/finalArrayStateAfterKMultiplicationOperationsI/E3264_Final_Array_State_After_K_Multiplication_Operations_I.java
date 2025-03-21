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
		int[] output = solution.getFinalState(input, k, multiplier);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
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
