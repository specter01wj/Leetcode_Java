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
