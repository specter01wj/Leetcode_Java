package com.pathCrossing;
import java.util.*;

/*
Given a string path, where path[i] = 'N', 'S', 'E' or 'W', 
each representing moving one unit north, south, east, or west, 
respectively. You start at the origin (0, 0) on a 2D plane 
and walk on the path specified by path.

Return true if the path crosses itself at any point, that is, 
if at any time you are on a location you have previously visited. 
Return false otherwise.
*/

public class E1496_Path_Crossing {

	public static void main(String[] args) {
		E1496_Path_Crossing solution = new E1496_Path_Crossing();
		String input = "NESWW";
		boolean output = solution.isPathCrossing(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashSet
    */
	
	/*
     * @param path: a string
     * @return: true if the path crosses itself at any point
     */
	public boolean isPathCrossing(String path) {
        // Set to store visited coordinates as string "x,y"
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;

        visited.add("0,0"); // starting point

        for (char dir : path.toCharArray()) {
            switch (dir) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }

            String pos = x + "," + y;
            if (visited.contains(pos)) {
                return true;
            }
            visited.add(pos);
        }

        return false;
    }

}
