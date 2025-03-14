package com.findtheSumofEncryptedIntegers;
import java.util.*;

/*
You are given an integer array nums containing positive integers. 
We define a function encrypt such that encrypt(x) replaces every 
digit in x with the largest digit in x. 
For example, encrypt(523) = 555 and encrypt(213) = 333.

Return the sum of encrypted elements.
*/

public class E3079_Find_the_Sum_of_Encrypted_Integers {

	public static void main(String[] args) {
		E3079_Find_the_Sum_of_Encrypted_Integers solution = new E3079_Find_the_Sum_of_Encrypted_Integers();
		int[] input = {10,21,31};
		int output = solution.sumOfEncryptedInt(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Iterate through the Array:
		. For each number in the array, find the maximum digit.
	2. Find the Largest Digit:
		. Use a loop to extract each digit using % 10 and update the maxDigit.
	3. Construct the Encrypted Value:
		. Replace each digit of the number with maxDigit by reconstructing the number.
	4. Add the Encrypted Value to the Sum:
		. Add the computed encrypted value to the total sum.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the sum of encrypted elements
     */
	public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            int maxDigit = 0;
            int temp = num;

            // Find the largest digit in the current number
            while (temp > 0) {
                int digit = temp % 10;
                maxDigit = Math.max(maxDigit, digit);
                temp /= 10;
            }

            // Replace all digits with the largest digit
            int encryptedValue = 0;
            int placeValue = 1;
            while (num > 0) {
                encryptedValue += maxDigit * placeValue;
                placeValue *= 10;
                num /= 10;
            }

            // Add the encrypted value to the sum
            sum += encryptedValue;
        }

        return sum;
    }

}
