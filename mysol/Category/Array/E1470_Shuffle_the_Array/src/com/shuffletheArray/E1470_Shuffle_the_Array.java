package com.shuffletheArray;
import java.util.*;

/*
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].


Example 1:

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7] 
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

Example 2:

Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]

Example 3:

Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]
*/

public class E1470_Shuffle_the_Array {

	public static void main(String[] args) {
		int[] input = {2,5,1,3,4,7};
		int n = 3;
		int[] output = shuffle(input, n);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. Store the pair of numbers and then
	2. Retreive each number, from that pair where they were stored, 
	one by one and place them at their desired positions.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the array in the form [x1,y1,x2,y2,...,xn,yn]
     */
	public static int[] shuffle(int[] input, int n) {
		int[] nums = input.clone();
        int len = nums.length;
        for(int i = n; i < len; i++) {
            nums[i] = (nums[i] * 1024) + nums[i - n];
        }
        int index = 0;
        for(int i = n; i < len; i++, index += 2) {
            nums[index] = nums[i] % 1024;
            nums[index + 1] = nums[i] / 1024;
        }
        return nums;
    }

}
