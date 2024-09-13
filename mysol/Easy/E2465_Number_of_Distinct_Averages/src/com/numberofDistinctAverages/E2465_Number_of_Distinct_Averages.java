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
		int[] inputCopy = Arrays.copyOf(input, input.length);
		int output = solution.distinctAverages(inputCopy);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Sorting the Array: We first sort the array. After sorting, 
    	we can easily access the minimum element from the left 
    	(starting at index 0) and the maximum element from the right 
    	(starting at the last index).
	2. Two-Pointer Approach: We use two pointers (left and right) to 
		pick the smallest and largest numbers, calculate their average, 
		and add that average to a Set<Double> to ensure only distinct 
		averages are stored.
	3. Set for Distinct Averages: A HashSet is used to store the distinct 
		averages, which automatically handles any duplicates.
	4. Loop: We continue this process of removing the minimum and maximum 
		until the pointers meet or cross.
	5. Return Result: The size of the set represents the number of distinct averages.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the number of distinct averages calculated using the above process
     */
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
