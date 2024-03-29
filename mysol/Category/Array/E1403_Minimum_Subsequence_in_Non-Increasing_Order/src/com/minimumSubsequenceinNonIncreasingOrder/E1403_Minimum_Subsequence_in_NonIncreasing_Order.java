package com.minimumSubsequenceinNonIncreasingOrder;
import java.util.*;

/*
Given the array nums, obtain a subsequence of the array whose sum of elements 
is strictly greater than the sum of the non included elements in such subsequence. 

If there are multiple solutions, return the subsequence with minimum size and 
if there still exist multiple solutions, return the subsequence with the maximum 
total sum of all its elements. A subsequence of an array can be obtained by 
erasing some (possibly zero) elements from the array. 

Note that the solution with the given constraints is guaranteed to be unique. 
Also return the answer sorted in non-increasing order.


Example 1:

Input: nums = [4,3,10,9,8]
Output: [10,9] 
Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of 
their elements is strictly greater than the sum of elements not included. 
However, the subsequence [10,9] has the maximum total sum of its elements. 

Example 2:

Input: nums = [4,4,7,6,7]
Output: [7,7,6] 
Explanation: The subsequence [7,7] has the sum of its elements equal to 14 which 
is not strictly greater than the sum of elements not included (14 = 4 + 4 + 6). 
Therefore, the subsequence [7,6,7] is the minimal satisfying the conditions. 
Note the subsequence has to be returned in non-decreasing order.  
*/

public class E1403_Minimum_Subsequence_in_NonIncreasing_Order {

	public static void main(String[] args) {
		int[] input = {4,3,10,9,8};
		List<Integer> output = minSubsequence(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    sort and keep adding from large side
    */
	
	/*
     * @param nums: a list of integers
     * @return: obtain a subsequence of the array
     */
	public static List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, sum = 0, rSum = 0;
        for (int i : nums) {
            sum += i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            rSum += nums[i];
            res.add(nums[i]);
            if (rSum > sum - rSum) {
               return res; 
            }
        }
        return new ArrayList<>();
    }

}
