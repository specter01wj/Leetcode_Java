package com.maximumSum;
import java.util.*;

/*
You are given a 0-indexed array nums consisting of positive integers. 
You can choose two indices i and j, such that i != j, and the sum of 
digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over 
all possible indices i and j that satisfy the conditions. 
If no such pair of indices exists, return -1.
*/

public class Ch3_maximumSum {

	public static void main(String[] args) {
		Ch3_maximumSum solution = new Ch3_maximumSum();
		int[] input = {18,43,36,13,7};
		int output = solution.maximumSum(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param nums: a list of integers
     * @return: the maximum value of nums[i] + nums[j]
     */
	public int maximumSum(int[] nums) {
        Map<Integer, Integer> digitSumToMax = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (digitSumToMax.containsKey(digitSum)) {
                int prevMax = digitSumToMax.get(digitSum);
                maxSum = Math.max(maxSum, prevMax + num);
                digitSumToMax.put(digitSum, Math.max(prevMax, num));
            } else {
                digitSumToMax.put(digitSum, num);
            }
        }

        return maxSum;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
