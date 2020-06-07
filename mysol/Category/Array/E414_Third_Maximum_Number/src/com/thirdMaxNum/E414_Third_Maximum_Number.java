package com.thirdMaxNum;
import java.util.*;

/*Given a non-empty array of integers, return the third maximum number in this array. 
 If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.*/

public class E414_Third_Maximum_Number {

	public static void main(String[] args) {
		int[] input = {2,2,3,1};
        int output = thirdMax(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
	 * solution:
	1. 用三个变量来存放第一大，第二大，第三大的元素的变量，分别为one, two, three；
	2. 遍历数组，若该元素比one大则往后顺移一个元素，比two大则往往后顺移一个元素，比three大则赋值个three；
	3. 最后得到第三大的元素，若没有则返回第一大的元素。
	*/
	
	/**
     * @param nums: the array
     * @return: the third maximum number in this array
     */
	public static int thirdMax(int[] nums) {
		long memory[] = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == memory[0] || nums[i] == memory[1] || nums[i] == memory[2]) {
				continue;
			}
			if(nums[i] > memory[2]) {
				memory[0] = memory[1];
				memory[1] = memory[2];
				memory[2] = nums[i];
			} else if(nums[i] > memory[1]) {
				memory[0] = memory[1];
				memory[1] = nums[i];
			} else if(nums[i] > memory[0]) {
				memory[0] = nums[i];
			}
		}
		
		for(int i = 0; i < memory.length; i++) {
			if(memory[i] == Long.MIN_VALUE) {
				return (int)memory[2];
			}
		}
		
		return (int)memory[0];
	}

}
