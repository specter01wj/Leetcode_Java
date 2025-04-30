package com.sumofGoodNumbers;
import java.util.*;

/*
Given an array of integers nums and an integer k, an element 
nums[i] is considered good if it is strictly greater than the 
elements at indices i - k and i + k (if those indices exist). 
If neither of these indices exists, nums[i] is still considered good.

Return the sum of all the good elements in the array.
*/

public class E3452_Sum_of_Good_Numbers {

	public static void main(String[] args) {
		int[] input = {1,3,2,1,5,4};
		int k = 2;
		int output = sumOfGoodNumbers(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int sumOfGoodNumbers(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            boolean isGood = true;

            // Check if i - k is within bounds
            if (i - k >= 0 && nums[i] <= nums[i - k]) {
                isGood = false;
            }

            // Check if i + k is within bounds
            if (i + k < n && nums[i] <= nums[i + k]) {
                isGood = false;
            }

            if (isGood) {
                sum += nums[i];
            }
        }

        return sum;
    }

}
