package com.minimumAverageofSmallestandLargestElements;
import java.util.*;

/*
You have an array of floating point numbers averages which is initially empty. 
You are given an array nums of n integers where n is even.

You repeat the following procedure n / 2 times:

	. Remove the smallest element, minElement, and the largest element maxElement, from nums.
	. Add (minElement + maxElement) / 2 to averages.

Return the minimum element in averages.
*/

public class E3194_Minimum_Average_of_Smallest_and_Largest_Elements {

	public static void main(String[] args) {
		E3194_Minimum_Average_of_Smallest_and_Largest_Elements solution = new E3194_Minimum_Average_of_Smallest_and_Largest_Elements();
		int[] input = {7,8,3,4,15,13,4,1};
		int[] intputCopy = Arrays.copyOf(input, input.length);
		double output = solution.minimumAverage(intputCopy);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Sort the Array - Sorting ensures that the smallest and largest elements are easily accessible at the beginning and end of the array.
	2. Two-Pointer Approach - Start from both ends (left and right) and iterate until they meet.
	3. Compute Averages - For each pair (min, max), compute (min + max) / 2 and add it to the averages list.
	4. Find the Minimum - Return the smallest value from the averages list.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the minimum element in averages
     */
	public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        List<Double> averages = new ArrayList<>();
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            double avg = (nums[left] + nums[right]) / 2.0;
            averages.add(avg);
            left++;
            right--;
        }
        
        return Collections.min(averages);
    }

}
