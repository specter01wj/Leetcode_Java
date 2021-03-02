package com.sortArrayByParityII;
import java.util.*;

/*Given an array of integers nums, half of the integers in nums are odd, 
and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever 
nums[i] is even, i is even.

Return any answer array that satisfies this condition.

 

Example 1:

Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

Example 2:

Input: nums = [2,3]
Output: [2,3]*/

public class E922_Sort_Array_By_Parity_II {

	public static void main(String[] args) {
		int[] input = {4,2,5,7};
		System.out.println("input: " + Arrays.toString(input));
        int[] output = sortArrayByParityII(input);
        System.out.println("output: " + Arrays.toString(output));
	}
	
	/*
    solution:
    使用双指针：一个奇数指针，指向奇数位；一个偶数指针，指向偶数位； 
    可以令偶数指针从前往后遍历，奇数指针从后往前遍历，
    偶数位若存的是偶数（或奇数位存的是奇数）是与题意相符的，
    可以直接跳过，找到一奇数位放偶数，一偶数位放了奇数，
    便可交换两位置的数，使其符合题意。
    */
	
	/**
     * @param A: 
     * @return: Sort Array By Parity II
     */
	public static int[] sortArrayByParityII(int[] nums) {
		int len = nums.length;
		int[] val = new int[nums.length];
		int even = 0, odd = 1;
		
		for(int i = 0; i < len; i++) {
			if((nums[i] & 1) == 0) {
				val[even] = nums[i];
				even += 2;
			} else {
				val[odd] = nums[i];
				odd += 2;
			}
		}
		
		return val;
	}

}
