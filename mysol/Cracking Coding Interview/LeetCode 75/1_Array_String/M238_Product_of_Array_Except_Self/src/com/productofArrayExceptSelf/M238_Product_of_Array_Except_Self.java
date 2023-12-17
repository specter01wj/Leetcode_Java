package com.productofArrayExceptSelf;
import java.util.*;

/*
Given an integer array nums, return an array answer such that answer[i] is 
equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
*/

public class M238_Product_of_Array_Except_Self {

	public static void main(String[] args) {
		int[] input = {1,2,3,4};
		int[] output = productExceptSelf(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        
        // Arrays to store left and right products
        int[] leftProducts = new int[length];
        int[] rightProducts = new int[length];

        // Array for the result
        int[] answer = new int[length];

        // Initialize the left most product as 1
        leftProducts[0] = 1;
        for (int i = 1; i < length; i++) {
            leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
        }

        // Initialize the right most product as 1
        rightProducts[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
        }

        // Construct the answer array
        for (int i = 0; i < length; i++) {
            answer[i] = leftProducts[i] * rightProducts[i];
        }

        return answer;
    }

}
