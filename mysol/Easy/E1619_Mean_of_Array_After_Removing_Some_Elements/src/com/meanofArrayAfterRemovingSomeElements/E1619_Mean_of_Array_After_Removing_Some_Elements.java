package com.meanofArrayAfterRemovingSomeElements;
import java.util.*;

/*
Given an integer array arr, return the mean of the remaining integers 
after removing the smallest 5% and the largest 5% of the elements.

Answers within 10-5 of the actual answer will be considered accepted.


Example 1:

Input: arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
Output: 2.00000
Explanation: After erasing the minimum and the maximum values of this array, 
all elements are equal to 2, so the mean is 2.

Example 2:

Input: arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
Output: 4.00000

Example 3:

Input: arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
Output: 4.77778
*/

public class E1619_Mean_of_Array_After_Removing_Some_Elements {

	public static void main(String[] args) {
		int[] input = {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
		double output = trimMean(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Sort and sum.
    */
	
	/*
     * @param arr: a list of integers
     * @return: the mean of the remaining integers
     */
	public static double trimMean(int[] arr) {
		int n = arr.length;
        double sum = 0d;
        Arrays.sort(arr);
        for (int i = n / 20; i < n - n / 20; ++i) {
            sum += arr[i];
        }
        return sum / (n * 9 / 10); 
    }

}
