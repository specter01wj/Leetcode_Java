package com.countingElements;
import java.util.*;

/*
Given an integer array arr, count how many elements x there are, 
such that x + 1 is also in arr. If there are duplicates in arr, 
count them separately.
*/

public class E1426_Counting_Elements {

	public static void main(String[] args) {
		E1426_Counting_Elements solution = new E1426_Counting_Elements();
		int[] input = {1, 2, 3};
		int output = solution.countElements(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Using a HashSet:
		. We store all the elements of the array in a HashSet because checking 
			if an element exists in a set is O(1) on average.
	2. Counting Valid Elements:
		. We iterate over the array and for each element num, we check if num + 1 is in the set.
		. If it is, we increment the count because num meets the condition.
	3. Edge Cases:
		. If the array is empty, the function will naturally return 0.
		. Duplicates in the array will be handled correctly since each occurrence 
			is counted separately as the problem requires.
    */
	
	/*
     * @param arr: a list of integers
     * @return: count how many elements
     */
	public int countElements(int[] arr) {
        // Use a HashSet to store the unique elements from the array
        Set<Integer> elementsSet = new HashSet<>();
        for (int num : arr) {
            elementsSet.add(num);
        }

        int count = 0;
        // Loop through the array and check if num + 1 exists in the set
        for (int num : arr) {
            if (elementsSet.contains(num + 1)) {
                count++;
            }
        }

        return count;
    }

}
