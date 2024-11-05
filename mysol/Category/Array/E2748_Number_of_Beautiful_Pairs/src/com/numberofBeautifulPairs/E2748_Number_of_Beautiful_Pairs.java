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
