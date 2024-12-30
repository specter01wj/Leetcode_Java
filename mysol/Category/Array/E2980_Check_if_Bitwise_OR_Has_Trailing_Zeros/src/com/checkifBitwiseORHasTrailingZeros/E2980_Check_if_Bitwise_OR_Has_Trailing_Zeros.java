package com.checkifBitwiseORHasTrailingZeros;
import java.util.*;

/*
You are given an array of positive integers nums.

You have to check if it is possible to select two or more elements 
in the array such that the bitwise OR of the selected elements has 
at least one trailing zero in its binary representation.

For example, the binary representation of 5, which is "101", does 
not have any trailing zeros, whereas the binary representation of 4, 
which is "100", has two trailing zeros.

Return true if it is possible to select two or more elements whose 
bitwise OR has trailing zeros, return false otherwise.
*/

public class E2980_Check_if_Bitwise_OR_Has_Trailing_Zeros {

	public static void main(String[] args) {
		E2980_Check_if_Bitwise_OR_Has_Trailing_Zeros solution = new E2980_Check_if_Bitwise_OR_Has_Trailing_Zeros();
		int[] input = {1,2,3,4,5};
		boolean output = solution.hasTrailingZeros(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Outer Loop: Iterates through each element in the array.
	2. Inner Loop: Iterates through the subsequent elements to form all pairs.
	3. Bitwise OR: Calculates the OR of two selected numbers.
	4. Trailing Zero Check: (bitwiseOr & 1) == 0 checks if the least significant bit is zero, indicating at least one trailing zero.
	5. Return True: If a valid pair is found, return true immediately.
	6. Return False: If no pairs satisfy the condition, return false.
    */
	
	/*
     * @param nums: a list of integers
     * @return: true if it is possible to select two or more elements whose bitwise OR has trailing zeros
     */
	public boolean hasTrailingZeros(int[] nums) {
        // Iterate through all pairs of elements in the array
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Calculate the bitwise OR of nums[i] and nums[j]
                int bitwiseOr = nums[i] | nums[j];

                // Check if the bitwise OR has at least one trailing zero
                if ((bitwiseOr & 1) == 0) {
                    return true; // Found at least one pair with trailing zero
                }
            }
        }

        // If no such pair is found, return false
        return false;
    }

}
