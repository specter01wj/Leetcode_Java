package com.sortthePeople;
import java.util.*;

/*
You are given an array of strings names, and an array heights 
that consists of distinct positive integers. Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and 
height of the ith person.

Return names sorted in descending order by the people's heights.
*/

public class E2418_Sort_the_People {

	public static void main(String[] args) {
		E2418_Sort_the_People solution = new E2418_Sort_the_People();
		String[] input = {"Mary","John","Emma"};
		int[] heights = {180,165,170};
		String[] output = solution.sortPeople(input, heights);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. Index Array Creation:
		. We first create an array indices of the same length 
			as names to store the indices of the elements.
	2. Sorting:
		. We then sort this indices array based on the corresponding 
			heights array, in descending order.
	3. Result Construction:
		. Finally, we create a new array sortedNames by placing the 
			names in the order dictated by the sorted indices array.
    */
	
	/*
     * @param names: a list of strings
     * @param heights: a list of integers
     * @return: names sorted in descending order by the people's heights
     */
	public String[] sortPeople(String[] names, int[] heights) {
        // Create an array of indices
        Integer[] indices = new Integer[names.length];
        for (int i = 0; i < names.length; i++) {
            indices[i] = i;
        }

        // Sort the indices array based on the corresponding heights in descending order
        Arrays.sort(indices, (a, b) -> Integer.compare(heights[b], heights[a]));

        // Create a new array for the sorted names
        String[] sortedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            sortedNames[i] = names[indices[i]];
        }

        return sortedNames;
    }

}
