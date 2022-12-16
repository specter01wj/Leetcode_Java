package com.checkIfAll1sAreatLeastLengthKPlacesAway;
import java.util.*;

/*
Given an binary array nums and an integer k, return true if all 1's are 
at least k places away from each other, otherwise return false.


Example 1:


Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.

Example 2:


Input: nums = [1,0,0,1,0,1], k = 2
Output: false
Explanation: The second 1 and third 1 are only one apart from each other.
*/

public class E1437_Check_If_All_1s_Are_at_Least_Length_K_Places_Away {

	public static void main(String[] args) {
		int[] input = {1,0,0,0,1,0,0,1};
		boolean output = kLengthApart(input, 2);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    This question uses the concept of Prefix Sum and can be optimally solved in 
    One-Pass w/ Constant-Space.
	To solve this question, we need to find the Minimum Prefix Sum <= 0 ending at each index.
	At an index i:
	prefixSum = Sum of first i elements.
	To keep track of the minimum prefix sum, we use minVal. It is initially assigned to zero 
	so that we can find the minimum prefix sum <= 0.
	Final Minimum Positive startValue will be 1 - Minimum Prefix Sum as this will ensure 
	that the prefix sum is always >= 1 at every index of the input array.
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: true if all 1's are at least k places away from each other, otherwise return false
     */
	public static boolean kLengthApart(int[] nums, int k) {
        int lastOne = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(lastOne != -1 && i - lastOne <= k) {
                    return false;
                }
                lastOne = i;
            }
        }
	    return true;
    }

}
