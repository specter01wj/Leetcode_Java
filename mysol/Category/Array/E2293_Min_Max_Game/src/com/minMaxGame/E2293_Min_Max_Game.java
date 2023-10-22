package com.minMaxGame;
import java.util.*;

/*
You are given a 0-indexed integer array nums whose length is a power of 2.

Apply the following algorithm on nums:

1. Let n be the length of nums. If n == 1, end the process. Otherwise, 
	create a new 0-indexed integer array newNums of length n / 2.
2. For every even index i where 0 <= i < n / 2, assign the value of newNums[i] 
	as min(nums[2 * i], nums[2 * i + 1]).
3. For every odd index i where 0 <= i < n / 2, assign the value of newNums[i] 
	as max(nums[2 * i], nums[2 * i + 1]).
4. Replace the array nums with newNums.
5. Repeat the entire process starting from step 1.

Return the last number that remains in nums after applying the algorithm.
*/

public class E2293_Min_Max_Game {

	public static void main(String[] args) {
		int[] input = {1,3,5,2,4,8,2,2};
		int output = minMaxGame(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    calculate min and max, and get the remains
    */
	
	/*
     * @param arr: a list of integers
     * @return: the last number that remains in nums after applying the algorithm
     */
	public static int minMaxGame(int[] nums) {
		while (nums.length > 1) {
			int n = nums.length;
			int[] newNums = new int[n / 2];
			
			for (int i = 0; i < n / 2; i++) {
				if (i % 2 == 0) {
					newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
				} else {
					newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
				}
			}
			
			nums = newNums;
		}
		
		return nums[0];
	}

}
