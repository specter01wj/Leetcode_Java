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
