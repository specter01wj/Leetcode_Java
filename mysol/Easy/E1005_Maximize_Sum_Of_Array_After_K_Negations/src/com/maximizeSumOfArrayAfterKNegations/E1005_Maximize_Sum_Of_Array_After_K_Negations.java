package com.maximizeSumOfArrayAfterKNegations;
import java.util.*;

/*
Given an integer array nums and an integer k, modify the array 
in the following way:

. choose an index i and replace nums[i] with -nums[i].

You should apply this process exactly k times. You may choose 
the same index i multiple times.

Return the largest possible sum of the array after modifying it in this way.


Example 1:

Input: nums = [4,2,3], k = 1
Output: 5
Explanation: Choose index 1 and nums becomes [4,-2,3].

Example 2:

Input: nums = [3,-1,0,2], k = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].

Example 3:

Input: nums = [2,-3,-1,5,-4], k = 2
Output: 13
Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
*/

public class E1005_Maximize_Sum_Of_Array_After_K_Negations {

	public static void main(String[] args) {
		int[] input = {4,2,3};
		int k = 1;
		int output = largestSumAfterKNegations(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1- sort the numbers in ascending order
	2- flip all the negative numbers, as long as k > 0
	3- find the sum of the new array (with flipped numbers if any) and 
		keep track of the minimum number
	4- Now for the return statement
	
	res is the total sum of the new array
	K % 2 check if the remaining K is odd.
	
	Because if it's even, it will have no effect
	(we will flip a number and then get it back to the original)
	
	If it's odd,
	flip the minimum number and remove twice its value from the result
	(twice because we already added it as positive in our sum operation)
    */
	
	/*
     * @param nums: an array
     * @param k: an integer
     * @return: the largest possible sum of the array after modifying it in this way
     */
	public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; k > 0 && i < nums.length && nums[i] < 0; ++i, --k) {
            nums[i] = -nums[i];
        }
        int res = 0, min = Integer.MAX_VALUE;
        for (int a : nums) {
            res += a;
            min = Math.min(min, a);
        }
        
        return res - (k % 2) * min * 2;
    }

}
