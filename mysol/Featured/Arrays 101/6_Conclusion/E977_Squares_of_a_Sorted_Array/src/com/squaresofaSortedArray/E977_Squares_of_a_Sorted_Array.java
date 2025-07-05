package com.squaresofaSortedArray;
import java.util.*;

/*
Given an integer array nums sorted in non-decreasing order, 
return an array of the squares of each number sorted in non-decreasing order.
*/

public class E977_Squares_of_a_Sorted_Array {

	public static void main(String[] args) {
		E977_Squares_of_a_Sorted_Array solution = new E977_Squares_of_a_Sorted_Array();
		int[] input = {-4,-1,0,3,10};
		int[] output = solution.sortedSquares(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. Since negative numbers squared can be larger than some positive numbers 
    	squared, we use two pointers at both ends of the array.
	2. Compare the squares of the values at each end.
	3. Fill the result array from the back (pos = n - 1) with the larger square 
		each time.
    */
	
	/*
     * @param nums: a list of integers
     * @return: an array of the squares of each number sorted in non-decreasing order
     */
	public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int pos = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[pos--] = leftSquare;
                left++;
            } else {
                result[pos--] = rightSquare;
                right--;
            }
        }

        return result;
    }

}
