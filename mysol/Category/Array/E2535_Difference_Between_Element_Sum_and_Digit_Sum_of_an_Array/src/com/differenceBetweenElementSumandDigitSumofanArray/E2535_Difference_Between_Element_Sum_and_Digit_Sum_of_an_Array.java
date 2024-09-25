package com.differenceBetweenElementSumandDigitSumofanArray;
import java.util.*;

/*
You are given a positive integer array nums.

	. The element sum is the sum of all the elements in nums.
	. The digit sum is the sum of all the digits (not necessarily distinct) that appear in nums.

Return the absolute difference between the element sum and digit sum of nums.
*/

public class E2535_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array {

	public static void main(String[] args) {
		E2535_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array solution = new E2535_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array();
		int[] input = {1,15,6,3};
		int output = solution.differenceOfSum(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    sum up element and digit and compare
    */
	
	/*
     * @param nums: a list of integers
     * @return: the absolute difference between the element sum and digit sum of nums
     */
	public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;

        // Calculate element sum and digit sum
        for (int num : nums) {
            elementSum += num;

            // Calculate the digit sum of the current number
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }
        }

        // Return the absolute difference between element sum and digit sum
        return Math.abs(elementSum - digitSum);
    }

}
