package com.uniqueNumberofOccurrences;
import java.util.*;

/*
Given an array of integers arr, return true if the number of 
occurrences of each value in the array is unique, or false otherwise.


Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. 
No two values have the same number of occurrences.

Example 2:

Input: arr = [1,2]
Output: false

Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
*/

public class E1207_Unique_Number_of_Occurrences {

	public static void main(String[] args) {
		int[] input = {1,2,2,1,1,3};
		boolean output = uniqueOccurrences(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    using 2 arrays
    */
	
	/*
     * @param arr: a list of strings
     * @return: find common characters
     */
	public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr) {
            count.put(a, 1 + count.getOrDefault(a, 0));
        }
        return count.size() == new HashSet<>(count.values()).size();
    }

}
