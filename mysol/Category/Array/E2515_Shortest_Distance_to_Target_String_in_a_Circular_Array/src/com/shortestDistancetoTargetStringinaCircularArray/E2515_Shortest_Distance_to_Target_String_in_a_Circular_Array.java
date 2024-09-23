package com.shortestDistancetoTargetStringinaCircularArray;
import java.util.*;

/*
You are given a 0-indexed circular string array words and a string target. 
A circular array means that the array's end connects to the array's beginning.

	. Formally, the next element of words[i] is words[(i + 1) % n] and the 
		previous element of words[i] is words[(i - 1 + n) % n], where n is 
		the length of words.

Starting from startIndex, you can move to either the next word or the previous 
word with 1 step at a time.

Return the shortest distance needed to reach the string target. 
If the string target does not exist in words, return -1.
*/

public class E2515_Shortest_Distance_to_Target_String_in_a_Circular_Array {

	public static void main(String[] args) {
		E2515_Shortest_Distance_to_Target_String_in_a_Circular_Array solution = new E2515_Shortest_Distance_to_Target_String_in_a_Circular_Array();
		String[] input = {"hello","i","am","leetcode","hello"};
		String target = "hello";
		int startIndex = 1;
		int output = solution.closetTarget(input, target, startIndex);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Initialization:
		. n is the length of the words array.
		. minDistance is initialized to the maximum integer value to keep track of the minimum distance found.
	2. Iterating Through the Array:
		. We loop through each index i in the words array.
		. If words[i] equals the target, we proceed to calculate the distance.
	3. Calculating Distances:
		. Forward Distance:
			. Calculated using (i - startIndex + n) % n.
			. This formula accounts for the circular nature of the array and ensures a non-negative result.
		. Backward Distance:
			. Calculated using (startIndex - i + n) % n.
			. Similarly adjusted for the circular array.
		. We take the minimum of the forward and backward distances as the shortest path to the current target.
	4. Updating Minimum Distance:
		. We compare the calculated distance with minDistance and update minDistance if the new distance is smaller.
	5. Final Result:
		. After checking all occurrences of the target, if minDistance remains Integer.MAX_VALUE, it means the target 
			was not found in the array, so we return -1.
		. Otherwise, we return the minDistance, which is the shortest distance to reach the target from the startIndex.
    */
	
	/*
     * @param words: a list of strings
     * @param target: a string
     * @param startIndex: an integer
     * @return: the shortest distance needed to reach the string target
     */
	public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                // Calculate the distance moving forward
                int forwardDistance = (i - startIndex + n) % n;
                // Calculate the distance moving backward
                int backwardDistance = (startIndex - i + n) % n;
                // Choose the minimum distance
                int distance = Math.min(forwardDistance, backwardDistance);
                // Update the minimum distance found so far
                minDistance = Math.min(minDistance, distance);
            }
        }

        // If the target is not found, return -1
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

}
