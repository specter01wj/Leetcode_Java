package com.sumofDigitsintheMinimumNumber;
import java.util.*;

/*
Given an integer array nums, return 0 if the sum of the digits 
of the minimum integer in nums is odd, or 1 otherwise.
*/

public class E1085_Sum_of_Digits_in_the_Minimum_Number {

	public static void main(String[] args) {
		E1085_Sum_of_Digits_in_the_Minimum_Number solution = new E1085_Sum_of_Digits_in_the_Minimum_Number();
		int[] input = {34,23,1,24,75,33,54,8};
		int output = solution.sumOfDigits(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Find the Minimum Element:
		. Initialize minElement to the first element in the array.
		. Iterate through the array and update minElement if a smaller element is found.
	2. Sum the Digits of the Minimum Element:
		. Use a while loop to repeatedly extract the last digit of minElement using the modulus operator (%) and add it to sumOfDigits.
		. Remove the last digit by dividing minElement by 10.
	3. Check if the Sum is Odd or Even:
		. Use the modulus operator to determine if sumOfDigits is odd or even.
		. Return 1 if sumOfDigits is even, otherwise return 0.
    */
	
	/*
     * @param nums: a list of integers
     * @return: 0 if the sum of the digits of the minimum integer in nums is odd, or 1 otherwise
     */
	public int sumOfDigits(int[] nums) {
        // Step 1: Find the minimum element in the array
        int minElement = nums[0];
        for (int num : nums) {
            if (num < minElement) {
                minElement = num;
            }
        }

        // Step 2: Calculate the sum of the digits of the minimum element
        int sumOfDigits = 0;
        while (minElement > 0) {
            sumOfDigits += minElement % 10;
            minElement /= 10;
        }

        // Step 3: Check if the sum of the digits is odd or even
        return sumOfDigits % 2 == 0 ? 1 : 0;
    }

}
