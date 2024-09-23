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
