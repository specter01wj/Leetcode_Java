package com.missingNumberInArithmeticProgression;
import java.util.*;

/*
In some array arr, the values were in arithmetic progression: 
the values arr[i + 1] - arr[i] are all equal for every 0 <= i < arr.length - 1.

A value from arr was removed that was not the first or last value in the array.

Given arr, return the removed value.
*/

public class E1228_Missing_Number_In_Arithmetic_Progression {

	public static void main(String[] args) {
		E1228_Missing_Number_In_Arithmetic_Progression solution = new E1228_Missing_Number_In_Arithmetic_Progression();
		int[] input = {5, 7, 11, 13};
		int output = solution.missingNumber(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Handling Equal Elements:
		. When all elements are the same (e.g., [0, 0, 0, 0, 0]), 
		  the difference (diff) will be 0. In this case, any missing number 
		  should also be 0. The code returns the first element in such cases.
	2. Edge Case for Single Element:
		. If the array only contains one element, it directly returns that 
		  element since there is no missing number in a single-element array.
    */
	
	/*
     * @param arr: a list of integers
     * @return: the removed value
     */
	public int missingNumber(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        int totalDiff = arr[n - 1] - arr[0];
        int expectedDiff = totalDiff / n;

        for (int i = 0; i < n - 1; i++) {
            int currentDiff = arr[i + 1] - arr[i];
            if (currentDiff != expectedDiff) {
                return arr[i] + expectedDiff;
            }
        }

        if (expectedDiff == 0) {
            return arr[0];
        }

        // If no discrepancy was found, return -1 or some other error code
        return -1;
    }

}
