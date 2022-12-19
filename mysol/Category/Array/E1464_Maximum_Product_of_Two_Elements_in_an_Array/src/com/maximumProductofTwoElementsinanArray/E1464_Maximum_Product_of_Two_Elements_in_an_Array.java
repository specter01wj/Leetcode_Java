package com.maximumProductofTwoElementsinanArray;
import java.util.*;

/*
Given the array of integers nums, you will choose two different indices 
i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).


Example 1:

Input: nums = [3,4,5,2]
Output: 12 
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), 
you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. 

Example 2:

Input: nums = [1,5,4,5]
Output: 16
Explanation: Choosing the indices i=1 and j=3 (indexed from 0), 
you will get the maximum value of (5-1)*(5-1) = 16.

Example 3:

Input: nums = [3,7]
Output: 12
*/

public class E1464_Maximum_Product_of_Two_Elements_in_an_Array {

	public static void main(String[] args) {
		int[] input = {3,4,5,2};
		int output = maxProduct(input);
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
     * @return: the maximum value of (nums[i]-1)*(nums[j]-1)
     */
	public static int maxProduct(int[] nums) {
        int mx1 = 0, mx2 = 0;
        for (int n : nums) {
            if (n > mx1) {
                mx2 = mx1;
                mx1 = n;
            } else if (n > mx2) {
                mx2 = n;
            }
        }
        return (mx1 - 1) * (mx2 - 1);
    }

}
