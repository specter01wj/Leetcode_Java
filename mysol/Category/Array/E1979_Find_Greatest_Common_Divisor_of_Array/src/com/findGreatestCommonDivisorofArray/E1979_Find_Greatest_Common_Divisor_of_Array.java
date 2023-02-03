package com.findGreatestCommonDivisorofArray;
import java.util.*;

/*
Given an integer array nums, return the greatest common divisor of the smallest 
number and largest number in nums.

The greatest common divisor of two numbers is the largest positive integer that 
evenly divides both numbers.


Example 1:

Input: nums = [2,5,6,9,10]
Output: 2
Explanation:
The smallest number in nums is 2.
The largest number in nums is 10.
The greatest common divisor of 2 and 10 is 2.

Example 2:

Input: nums = [7,5,6,8,3]
Output: 1
Explanation:
The smallest number in nums is 3.
The largest number in nums is 8.
The greatest common divisor of 3 and 8 is 1.

Example 3:

Input: nums = [3,3]
Output: 3
Explanation:
The smallest number in nums is 3.
The largest number in nums is 3.
The greatest common divisor of 3 and 3 is 3.
*/

public class E1979_Find_Greatest_Common_Divisor_of_Array {

	public static void main(String[] args) {
		int[] input = {2,5,6,9,10};
		int output = findGCD(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    It is based on the principle that the greatest common divisor of two numbers 
    does not change if the larger number is replaced by its difference with the smaller number.
	Since this replacement reduces the larger of the two numbers, repeating this 
	process gives successively smaller pairs of numbers until the two numbers become equal.
	When that occurs, they are the GCD of the original two numbers
    */
	
	/*
     * @param nums: a list of integers
     * @return: the greatest common divisor of the smallest number and largest number in nums
     */
	public static int findGCD(int[] nums) {
        int max = 0;
        int min = 1001;

        for (int e : nums) {
            max = Math.max(max, e);
            min = Math.min(min, e);
        }
        return gcd(min, max);
    }

    private static int gcd(int a, int b) {
		  if (b == 0) return a;
		  return gcd(b, a % b);
    }

}
