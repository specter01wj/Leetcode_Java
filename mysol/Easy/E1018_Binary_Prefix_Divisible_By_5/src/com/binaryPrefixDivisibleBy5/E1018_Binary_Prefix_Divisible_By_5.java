package com.binaryPrefixDivisibleBy5;
import java.util.*;

/*
You are given a binary array nums (0-indexed).

We define xi as the number whose binary representation is the 
subarray nums[0..i] (from most-significant-bit to least-significant-bit).

. For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.

Return an array of booleans answer where answer[i] is true if xi is divisible by 5.


Example 1:

Input: nums = [0,1,1]
Output: [true,false,false]
Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, 
and 3 in base-10.
Only the first number is divisible by 5, so answer[0] is true.

Example 2:

Input: nums = [1,1,1]
Output: [false,false,false]
*/

public class E1018_Binary_Prefix_Divisible_By_5 {

	public static void main(String[] args) {
		int[] input = {0,1,1};
		List<Boolean> output = prefixesDivBy5(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Contruct the number from a string in decimal like "12345678", 
    	key: num = num * 10 + (c - '0') where c is the current character.
	2. Contruct the number from a string in binary like "01010101", 
		key: num = num * 2 + (c - '0'), and faster: (num << 1) | (c - '0') where c is the current character.
		Or array format like [0, 1, 0, 1, 0, 1], key: num = (num << 1) | c where c is the current bit.
    */
	
	/*
     * @param prices: a list of integer
     * @return: an array of booleans answer where answer[i] is true if xi is divisible by 5
     */
	public static List<Boolean> prefixesDivBy5(int[] nums) {
        int k = 0;
        List<Boolean> ans = new ArrayList<>();
        for (int a : nums) {
            k = (k << 1 | a) % 5;
            ans.add(k == 0); 
        }
        return ans;
    }

}
