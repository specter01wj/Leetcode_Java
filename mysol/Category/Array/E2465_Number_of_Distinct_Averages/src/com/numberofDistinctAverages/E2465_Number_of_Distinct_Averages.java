package com.numberofDistinctAverages;
import java.util.*;

/*
You are given a 0-indexed integer array nums of even length.

As long as nums is not empty, you must repetitively:

	. Find the minimum number in nums and remove it.
	. Find the maximum number in nums and remove it.
	. Calculate the average of the two removed numbers.

The average of two numbers a and b is (a + b) / 2.

	. For example, the average of 2 and 3 is (2 + 3) / 2 = 2.5.

Return the number of distinct averages calculated using the above process.
*/

public class E2465_Number_of_Distinct_Averages {

	public static void main(String[] args) {
		E2465_Number_of_Distinct_Averages solution = new E2465_Number_of_Distinct_Averages();
		int[] input = {4,1,4,0,3,5};
		int output = solution.distinctAverages(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int distinctAverages(int[] nums) {
        // Sort the array to easily find the minimum and maximum
        Arrays.sort(nums);
        Set<Double> distinctAverages = new HashSet<>();

        int left = 0;
        int right = nums.length - 1;

        // Calculate the average of the minimum and maximum numbers, then remove them
        while (left < right) {
            double average = (nums[left] + nums[right]) / 2.0;
            distinctAverages.add(average);
            left++;
            right--;
        }

        // The size of the set represents the number of distinct averages
        return distinctAverages.size();
    }

}
