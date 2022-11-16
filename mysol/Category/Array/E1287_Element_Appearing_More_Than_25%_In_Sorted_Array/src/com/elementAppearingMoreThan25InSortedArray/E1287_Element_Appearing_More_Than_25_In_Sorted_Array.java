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
		List<String> output = commonChars(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}

}
