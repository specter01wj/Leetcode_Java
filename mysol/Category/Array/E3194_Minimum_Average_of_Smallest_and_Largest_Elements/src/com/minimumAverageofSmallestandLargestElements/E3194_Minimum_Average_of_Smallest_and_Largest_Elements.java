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
