package com.signoftheProductofanArray;
import java.util.*;

/*
There is a function signFunc(x) that returns:

	.1 if x is positive.
	.-1 if x is negative.
	.0 if x is equal to 0.
	
You are given an integer array nums. Let product be the product of all values in the array nums.

Return signFunc(product).


Example 1:

Input: nums = [-1,-2,-3,-4,3,2,1]
Output: 1
Explanation: The product of all values in the array is 144, and signFunc(144) = 1

Example 2:

Input: nums = [1,5,0,2,-3]
Output: 0
Explanation: The product of all values in the array is 0, and signFunc(0) = 0

Example 3:

Input: nums = [-1,1,-1,1,-1]
Output: -1
Explanation: The product of all values in the array is -1, and signFunc(-1) = -1
*/

public class E1822_Sign_of_the_Product_of_an_Array {

	public static void main(String[] args) {
		int[] input = {-1,-2,-3,-4,3,2,1};
		int output = arraySign(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Only care about 0 and the occurence of negative numbers in the array. 
    No need to calculate the final product.
    */
	
	/*
     * @param nums: a list of integers
     * @return: signFunc(product)
     */
	public static int arraySign(int[] nums) {
        int sign = 1; 
        for (int n : nums) {
            if (n == 0) {
                return 0; 
            } 
			if (n < 0) {
                sign = -sign; 
            }
        }
        return sign; 
    }

}
