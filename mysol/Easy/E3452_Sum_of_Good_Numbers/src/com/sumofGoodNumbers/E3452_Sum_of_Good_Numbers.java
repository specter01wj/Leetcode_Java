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
		E3452_Sum_of_Good_Numbers solution = new E3452_Sum_of_Good_Numbers();
		int[] input = {1,3,2,1,5,4};
		int k = 2;
		int output = solution.sumOfGoodNumbers(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Initialize sum to track total of good numbers.
	2. Loop through each index i in the array.
	3. Check left neighbor (i - k) if in bounds: nums[i] must be greater.
	4. Check right neighbor (i + k) if in bounds: nums[i] must be greater.
	5. If both valid conditions pass, add nums[i] to sum.
	6. Return the final sum after the loop.
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: the sum of all the good elements in the array
     */
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
