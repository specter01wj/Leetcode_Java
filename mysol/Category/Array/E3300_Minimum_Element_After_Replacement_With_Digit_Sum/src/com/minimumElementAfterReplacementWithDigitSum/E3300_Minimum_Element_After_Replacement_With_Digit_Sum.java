package com.minimumElementAfterReplacementWithDigitSum;
import java.util.*;

/*
You are given an integer array nums.

You replace each element in nums with the sum of its digits.

Return the minimum element in nums after all replacements.
*/

public class E3300_Minimum_Element_After_Replacement_With_Digit_Sum {

	public static void main(String[] args) {
		E3300_Minimum_Element_After_Replacement_With_Digit_Sum solution = new E3300_Minimum_Element_After_Replacement_With_Digit_Sum();
		int[] input = {10,12,13,14};
		int output = solution.minElement(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            min = Math.min(min, digitSum);
        }
        return min;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
