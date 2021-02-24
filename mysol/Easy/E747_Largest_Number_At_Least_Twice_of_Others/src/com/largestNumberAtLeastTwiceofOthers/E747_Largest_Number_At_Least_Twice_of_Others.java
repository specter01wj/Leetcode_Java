package com.largestNumberAtLeastTwiceofOthers;
import java.util.*;

/*In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as 
every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Example 1:

Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 
6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 

Example 2:

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 
4 isn't at least as big as twice the value of 3, so we return -1.
*/
public class E747_Largest_Number_At_Least_Twice_of_Others {

	public static void main(String[] args) {
		int[] input = {3, 6, 1, 0};
        int output = dominantIndex(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    在一次的遍历中找到最大的数max_first和第二大的数max2_second，
    然后看看最大的数（max1_first)是不是大于等于第二大的数(max2_second)的两倍，
    如果是,那么就满足最大数max_first大于等于数组中其他数组的两倍。
    */
	
	/*
     * @param nums: a integer array
     * @return: the index of the largest element
     */
	public static int dominantIndex(int[] nums) {
		if(nums == null || nums.length == 0) return -1;
		
		if(nums.length == 1) return 0;
		
		int max = Integer.MIN_VALUE + 1;
		int secondMax = Integer.MIN_VALUE;
		int index = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > max) {
				secondMax = max;
				max = nums[i];
				index = i;
			} else if(nums[i] != max && nums[i] > secondMax) {
				secondMax = nums[i];
			}
		}
		
		if(secondMax * 2 <= max) {
			return index;
		}
		
		return -1;
	}

}
