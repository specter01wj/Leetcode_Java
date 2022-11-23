package com.findNumberswithEvenNumberofDigits;
import java.util.*;

/*
Given an array nums of integers, return how many of them contain an even number of digits.


Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.

Example 2:

Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits.
*/

public class E1295_Find_Numbers_with_Even_Number_of_Digits {

	public static void main(String[] args) {
		int[] input = {12,345,2,6,7896};
		int output = findNumbers(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	/*
    solution:
    10-99 ---- EVEN digit
	1000-9999 --- EVEN digit
	100000 -- EVEN digit
    */
	
	/*
     * @param nums: a list of strings
     * @return: how many of them contain an even number of digits
     */
	public int findNumbers(int[] nums) {
        int count=0;
        for(int i =0 ; i< nums.length; i++){
            if((nums[i]>9 && nums[i]<100) || (nums[i]>999 && nums[i]<10000) || nums[i]==100000){
                count++;
            }
        }
        return count;
    }

}
