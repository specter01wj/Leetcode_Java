package com.pathCrossing;
import java.util.*;

/*
Given a string path, where path[i] = 'N', 'S', 'E' or 'W', 
each representing moving one unit north, south, east, or west, respectively. 
You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return true if the path crosses itself at any point, that is, 
if at any time you are on a location you have previously visited. Return false otherwise.


Example 1:


Input: path = "NES"
Output: false 
Explanation: Notice that the path doesn't cross any point more than once.

Example 2:


Input: path = "NESWW"
Output: true
Explanation: Notice that the path visits the origin twice.
*/

public class E1496_Path_Crossing {

	public static void main(String[] args) {
		String input = "NES";
        boolean output = isPathCrossing(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Create a hash for each point (x, y)
	x * 20001 + y, where 20001 > yMax - yMin, then use Set to check duplicate.
    */
	
	/**
     * @param s: a string
     * @return: after removing the outermost parentheses
     */
	public static boolean isPathCrossing(String path) {
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        for (int i = 0, x = 0, y = 0; i < path.length(); ++i) {
            char c = path.charAt(i);
            if (c == 'N') {
                y += 1;
            }else if (c == 'S') {
                y -= 1;
            }else if (c == 'E') {
                x -= 1;
            }else {
                x += 1;
            }
            if (!seen.add(x * 20001 + y)) {
                return true;
            }
        }
        return false;
    }

}
