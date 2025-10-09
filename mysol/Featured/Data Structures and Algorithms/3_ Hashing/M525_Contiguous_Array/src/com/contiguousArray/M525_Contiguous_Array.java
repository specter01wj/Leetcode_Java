package com.contiguousArray;
import java.util.*;

/*
Given a binary array nums, return the maximum length of a contiguous 
subarray with an equal number of 0 and 1.
*/

public class M525_Contiguous_Array {

	public static void main(String[] args) {
		M525_Contiguous_Array solution = new M525_Contiguous_Array();
		int[] input = {0,1,1,1,1,1,0,0,0};
		int output = solution.findMaxLength(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param nums: a list of integers
     * @return: the maximum length of a contiguous subarray
     */
	public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1); // base case

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, 1 as +1
            sum += (nums[i] == 0) ? -1 : 1;

            if (sumToIndex.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }

        return maxLen;
    }

}
