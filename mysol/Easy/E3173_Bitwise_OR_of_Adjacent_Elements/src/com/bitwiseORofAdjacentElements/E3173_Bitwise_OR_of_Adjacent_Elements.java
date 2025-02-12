package com.bitwiseORofAdjacentElements;
import java.util.*;

/*
Given an array nums of length n, return an array answer of 
length n - 1 such that answer[i] = nums[i] | nums[i + 1] 
where | is the bitwise OR operation.
*/

public class E3173_Bitwise_OR_of_Adjacent_Elements {

	public static void main(String[] args) {
		E3173_Bitwise_OR_of_Adjacent_Elements solution = new E3173_Bitwise_OR_of_Adjacent_Elements();
		int[] input = {1,3,7,15};
		int[] output = solution.orArray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. We initialize an array answer of size n - 1.
	2. We iterate through the nums array up to the second last element.
	3. At each index i, we compute the bitwise OR of nums[i] and nums[i + 1], storing the result in answer[i].
	4. Finally, we return the answer array.
    */
	
	/*
     * @param nums: a list of integers
     * @return: an array answer of length n - 1
     */
	public int[] orArray(int[] nums) {
		int n = nums.length;
		int[] answer = new int[n - 1];
		
		for (int i = 0; i < n - 1; i++) {
			answer[i] = nums[i] | nums[i + 1];
		}
		
		return answer;
	}

}
