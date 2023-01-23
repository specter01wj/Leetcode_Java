package com.sumofUniqueElements;
import java.util.*;

/*
You are given an integer array nums. The unique elements of an array 
are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums.


Example 1:

Input: nums = [1,2,3,2]
Output: 4
Explanation: The unique elements are [1,3], and the sum is 4.

Example 2:

Input: nums = [1,1,1,1,1]
Output: 0
Explanation: There are no unique elements, and the sum is 0.

Example 3:

Input: nums = [1,2,3,4,5]
Output: 15
Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
*/

public class E1748_Sum_of_Unique_Elements {

	public static void main(String[] args) {
		int[] input = {1,2,3,2};
		int output = sumOfUnique(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    count and sum
    */
	
	/*
     * @param nums: a list of integers
     * @return: the sum of all the unique elements of nums
     */
	public static int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        for (int n : nums) {
            ++cnt[n];
        }
        int sum = 0;
        for (int i = 1; i <= 100; ++i) {
            if (cnt[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }

}
