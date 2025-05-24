package com.findNumberswithEvenNumberofDigits;
import java.util.*;

/*
Given an array nums of integers, return how many of them contain an even number of digits.
*/

public class E1295_Find_Numbers_with_Even_Number_of_Digits {

	public static void main(String[] args) {
		E1295_Find_Numbers_with_Even_Number_of_Digits solution = new E1295_Find_Numbers_with_Even_Number_of_Digits();
		int[] input = {12,345,2,6,7896};
		int output = solution.findNumbers(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }

}
