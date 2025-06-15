package com.heightChecker;
import java.util.*;

/*
A school is trying to take an annual photo of all the students. 
The students are asked to stand in a single file line in non-decreasing 
order by height. Let this ordering be represented by the integer array 
expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that 
the students are standing in. Each heights[i] is the height of the ith 
student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].
*/

public class E1051_Height_Checker {

	public static void main(String[] args) {
		int[] input = {3,0,1,1,9,7};
		int output = countGoodTriplets(input, 7, 2, 3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Clone heights to expected to preserve the original order.
	2. Sort expected to get the correct height order.
	3. Compare each index of heights and expected, and count mismatches.
    */
	
	/*
     * @param heights: a list of integers
     * @return: the number of indices where heights[i] != expected[i]
     */
	public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }

        return count;
    }

}
