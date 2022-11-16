package com.elementAppearingMoreThan25InSortedArray;
import java.util.*;

/*
Given an integer array sorted in non-decreasing order, 
there is exactly one integer in the array that occurs more than 25% of the time, 
return that integer.


Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6

Example 2:

Input: arr = [1,1]
Output: 1
*/

public class E1287_Element_Appearing_More_Than_25_In_Sorted_Array {

	public static void main(String[] args) {
		int[] input = {1,2,2,6,6,6,6,7,10};
		int output = findSpecialInteger(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    sliding window solution
    */
	
	/*
     * @param arr: a list of integer
     * @return: one integer in the array that occurs more than 25% of the times
     */
	public static int findSpecialInteger(int[] arr) {
        int n = arr.length, t = n / 4;

        for (int i = 0; i < n - t; i++) {
            if (arr[i] == arr[i + t]) {
                return arr[i];
            }
        }
        return -1;
    }

}
