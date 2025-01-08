package com.antontheBoundary;
import java.util.*;

/*
An ant is on a boundary. It sometimes goes left and sometimes right.

You are given an array of non-zero integers nums. The ant starts 
reading nums from the first element of it to its end. At each step, 
it moves according to the value of the current element:

	. If nums[i] < 0, it moves left by -nums[i] units.
	. If nums[i] > 0, it moves right by nums[i] units.

Return the number of times the ant returns to the boundary.
*/

public class E3028_Ant_on_the_Boundary {

	public static void main(String[] args) {
		E3028_Ant_on_the_Boundary solution = new E3028_Ant_on_the_Boundary();
		int[] input = {2,3,-5};
		int output = solution.returnToBoundaryCount(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Position Tracking:
		. The variable position keeps track of the ant's current position relative to the boundary. The boundary is considered as position 0.
	2. Boundary Check:
		. After updating the position, the method checks if the position is 0. If true, it increments the boundaryCount.
	3. Output:
		. The method finally returns the total number of times the ant returned to the boundary.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the number of times the ant returns to the boundary
     */
	public int returnToBoundaryCount(int[] nums) {
        // Variable to track the current position of the ant
        int position = 0;
        // Variable to count the number of times the ant returns to the boundary
        int boundaryCount = 0;

        // Iterate through the given array
        for (int num : nums) {
            // Update the position of the ant based on the current step
            position += num;

            // Check if the ant is back to the boundary
            if (position == 0) {
                boundaryCount++;
            }
        }

        // Return the total count
        return boundaryCount;
    }

}
