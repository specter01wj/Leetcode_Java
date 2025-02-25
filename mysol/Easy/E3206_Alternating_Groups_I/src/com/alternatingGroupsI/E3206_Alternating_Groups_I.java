package com.alternatingGroupsI;
import java.util.*;

/*
There is a circle of red and blue tiles. You are given an array 
of integers colors. The color of tile i is represented by colors[i]:

	. colors[i] == 0 means that tile i is red.
	. colors[i] == 1 means that tile i is blue.

Every 3 contiguous tiles in the circle with alternating colors 
(the middle tile has a different color from its left and right tiles) 
is called an alternating group.

Return the number of alternating groups.
*/

public class E3206_Alternating_Groups_I {

	public static void main(String[] args) {
		E3206_Alternating_Groups_I solution = new E3206_Alternating_Groups_I();
		int[] input = {0,1,0,0,1};
		int output = solution.numberOfAlternatingGroups(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. We loop through each tile in the circular array.
	2. We determine the left (prev), current (curr), and right (next) 
		tiles while handling circular indexing using modulo (%).
	3. If prev != curr && curr != next, then it's an alternating group.
	4. We count such occurrences and return the result.
    */
	
	/*
     * @param colors: a list of integers
     * @return: the number of alternating groups
     */
	public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;

        // Iterate through the array considering it as a circular structure
        for (int i = 0; i < n; i++) {
            int prev = colors[(i - 1 + n) % n]; // Left tile
            int curr = colors[i];               // Middle tile
            int next = colors[(i + 1) % n];     // Right tile

            // Check if it forms an alternating group
            if (prev != curr && curr != next) {
                count++;
            }
        }

        return count;
    }

}
