package com.checkIfItIsaStraightLine;
import java.util.*;

/*
You are given an array coordinates, coordinates[i] = [x, y], 
where [x, y] represents the coordinate of a point. 
Check if these points make a straight line in the XY plane.


Example 1:

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:

Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
*/

public class E1232_Check_If_It_Is_a_Straight_Line {

	public static void main(String[] args) {
		int[][] input = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		boolean output = checkStraightLine(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
		public static boolean checkStraightLine(int[][] coordinates) {
		      int x0 = coordinates[0][0], y0 = coordinates[0][1], 
		            x1 = coordinates[1][0], y1 = coordinates[1][1];
		        int dx = x1 - x0, dy = y1 - y0;
		        for (int[] co : coordinates) {
		            int x = co[0], y = co[1];
		            if (dx * (y - y1) != dy * (x - x1)) {
		                return false;
		            }
		        }
		        return true;  
		    }

}
