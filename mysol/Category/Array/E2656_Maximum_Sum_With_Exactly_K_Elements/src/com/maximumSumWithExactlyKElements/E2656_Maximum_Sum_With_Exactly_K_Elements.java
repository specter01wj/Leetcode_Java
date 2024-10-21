package com.maximumSumWithExactlyKElements;
import java.util.*;

/*
You are given a 0-indexed integer array nums and an integer k. 
Your task is to perform the following operation exactly k times 
in order to maximize your score:

	1. Select an element m from nums.
	2. Remove the selected element m from the array.
	3. Add a new element with a value of m + 1 to the array.
	4. Increase your score by m.

Return the maximum score you can achieve after performing the 
operation exactly k times.
*/

public class E2656_Maximum_Sum_With_Exactly_K_Elements {

	public static void main(String[] args) {
		E2656_Maximum_Sum_With_Exactly_K_Elements solution = new E2656_Maximum_Sum_With_Exactly_K_Elements();
		int[] input = {1,2,3,4,5};
		int k = 3;
		int output = solution.maximizeSum(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int maximizeSum(int[] nums, int k) {
        // Find the maximum element in nums
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        
        // Perform k operations to maximize the sum
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += maxNum;  // Add the current largest number to the sum
            maxNum++;       // Increment the number by 1 for the next step
        }
        
        return sum;
    }

}
