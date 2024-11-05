package com.numberofBeautifulPairs;
import java.util.*;

/*
You are given a 0-indexed integer array nums. A pair of indices i, j 
where 0 <= i < j < nums.length is called beautiful if the first 
digit of nums[i] and the last digit of nums[j] are coprime.

Return the total number of beautiful pairs in nums.

Two integers x and y are coprime if there is no integer greater 
than 1 that divides both of them. In other words, x and y are 
coprime if gcd(x, y) == 1, where gcd(x, y) is the greatest 
common divisor of x and y.
*/

public class E2748_Number_of_Beautiful_Pairs {

	public static void main(String[] args) {
		E2748_Number_of_Beautiful_Pairs solution = new E2748_Number_of_Beautiful_Pairs();
		int[] input = {11,21,12};
		int output = solution.countBeautifulPairs(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Outer Loop: Iterate over each element in nums for i.
		. For each nums[i], get the first digit using getFirstDigit.
	2. Inner Loop: Iterate over each subsequent element for j > i.
		. For each nums[j], get the last digit using getLastDigit.
		. Check if the first digit of nums[i] and the last digit of 
			nums[j] are coprime by calculating the gcd.
		. If gcd(firstDigit, lastDigit) == 1, increment count.
	3. Helper Methods:
		. getFirstDigit: Finds the first digit by continuously dividing by 10.
		. getLastDigit: Returns num % 10, which is the last digit.
		. gcd: Uses the Euclidean algorithm to calculate the greatest common 
			divisor of two numbers.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the total number of beautiful pairs in nums
     */
	public int countBeautifulPairs(int[] nums) {
        int count = 0;

        // Iterate through all pairs (i, j) where i < j
        for (int i = 0; i < nums.length; i++) {
            int firstDigit = getFirstDigit(nums[i]);

            for (int j = i + 1; j < nums.length; j++) {
                int lastDigit = getLastDigit(nums[j]);

                // Check if the first digit of nums[i] and the last digit of nums[j] are coprime
                if (gcd(firstDigit, lastDigit) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    // Helper function to get the first digit of a number
    private int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    // Helper function to get the last digit of a number
    private int getLastDigit(int num) {
        return num % 10;
    }

    // Helper function to find gcd of two numbers
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
