package com.averageValueofEvenNumbersThatAreDivisiblebyThree;
import java.util.*;

/*
Given an integer array nums of positive integers, return the 
average value of all even integers that are divisible by 3.

Note that the average of n elements is the sum of the n elements 
divided by n and rounded down to the nearest integer.
*/

public class E2455_Average_Value_of_Even_Numbers_That_Are_Divisible_by_Three {

	public static void main(String[] args) {
		E2455_Average_Value_of_Even_Numbers_That_Are_Divisible_by_Three solution = new E2455_Average_Value_of_Even_Numbers_That_Are_Divisible_by_Three();
		int[] input = {1,3,6,10,12,15};
		int output = solution.averageValue(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    count good triplets
    */
	
	/*
     * @param nums: a list of integers
     * @return: the number of good triplets
     */
	public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        
        // Iterate through the array to find even numbers divisible by 3
        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                sum += num;
                count++;
            }
        }
        
        // Return the average (rounded down) or 0 if no such numbers found
        return count > 0 ? sum / count : 0;
    }

}
