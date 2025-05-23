package com.maxConsecutiveOnes;
import java.util.*;

/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.
*/

public class E485_Max_Consecutive_Ones {

	public static void main(String[] args) {
		E485_Max_Consecutive_Ones solution = new E485_Max_Consecutive_Ones();
		int[] input = {1,1,0,1,1,1};
		int output = solution.findMaxConsecutiveOnes(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }
        
        return maxCount;
    }

}
