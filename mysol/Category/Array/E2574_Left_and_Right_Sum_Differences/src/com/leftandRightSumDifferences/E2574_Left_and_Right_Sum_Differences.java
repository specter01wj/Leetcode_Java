package com.leftandRightSumDifferences;
import java.util.*;

/*
Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:

	. answer.length == nums.length.
	. answer[i] = |leftSum[i] - rightSum[i]|.

Where:

	. leftSum[i] is the sum of elements to the left of the index i in the array nums. 
		If there is no such element, leftSum[i] = 0.
	. rightSum[i] is the sum of elements to the right of the index i in the array nums. 
		If there is no such element, rightSum[i] = 0.

Return the array answer.
*/

public class E2574_Left_and_Right_Sum_Differences {

	public static void main(String[] args) {
		E2574_Left_and_Right_Sum_Differences solution = new E2574_Left_and_Right_Sum_Differences();
		int[] input = {10,4,8,3};
		int[] output = solution.leftRightDifference(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] answer = new int[n];

        // Calculate left sums
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        // Calculate right sums
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        // Calculate the answer array
        for (int i = 0; i < n; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return answer;
    }

}
