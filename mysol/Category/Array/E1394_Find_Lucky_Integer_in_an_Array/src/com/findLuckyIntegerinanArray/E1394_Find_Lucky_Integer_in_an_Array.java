package com.findLuckyIntegerinanArray;
import java.util.*;

/*
Given an array of integers arr, a lucky integer is an integer that 
has a frequency in the array equal to its value.

Return the largest lucky integer in the array. 
If there is no lucky integer return -1.


Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.

Example 3:

Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.
*/

public class E1394_Find_Lucky_Integer_in_an_Array {

	public static void main(String[] args) {
		int[] input = {1,2,2,3,3,3};
		int output = findLucky(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int findLucky(int[] arr) {
        int[] cnt = new int[501];
        for (int a : arr) {
            ++cnt[a];
        }
        for (int i = 500; i > 0; --i) {
            if (cnt[i] == i) {
                return i;
            }
        }
        return -1;
    }

}
