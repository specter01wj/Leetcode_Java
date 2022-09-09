package com.NRepeatedElementinSize2NArray;
import java.util.*;

/*
You are given an integer array nums with the following properties:

(*) nums.length == 2 * n.
(*) nums contains n + 1 unique elements.
(*) Exactly one element of nums is repeated n times.

Return the element that is repeated n times.


Example 1:

Input: nums = [1,2,3,3]
Output: 3

Example 2:

Input: nums = [2,1,2,5,3,2]
Output: 2

Example 3:

Input: nums = [5,1,5,2,5,3,5,4]
Output: 5
*/

public class E961_NRepeated_Element_in_Size_2N_Array {

	public static void main(String[] args) {
		int[] input = {2,1,2,5,3,2};
        int output = repeatedNTimes(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Use array or set and return seen number at once.
    */
	
	/**
     * @param nums: an array
     * @return: the element repeated n times
     */
	public static int repeatedNTimes(int[] nums) {
		int[] count = new int[10000];
        for (int a : nums) {
            if (count[a]++ == 1) {
                return a;
            }
        }
        return -1;
	}

}
