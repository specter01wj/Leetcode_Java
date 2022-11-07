package com.minimumTimeVisitingAllPoints;
import java.util.*;

/*
On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. 
Return the minimum time in seconds to visit all the points in the order given by points.

You can move according to these rules:

. In 1 second, you can either:
	. move vertically by one unit,
	. move horizontally by one unit, or
	. move diagonally sqrt(2) units (in other words, move one unit vertically 
	  then one unit horizontally in 1 second).
. You have to visit the points in the same order as they appear in the array.
. You are allowed to pass through points that appear later in the order, 
  but these do not count as visits.


Example 1:

Input: points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation: One optimal path is 
[1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   
Time from [1,1] to [3,4] = 3 seconds 
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds

Example 2:

Input: points = [[3,2],[-2,2]]
Output: 5
*/

public class E1266_Minimum_Time_Visiting_All_Points {

	public static void main(String[] args) {
		int[][] input = {{1,1},{3,4},{-1,0}};
        int output = minTimeToVisitAllPoints(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Traverse the input array, for each pair of neighboring points, 
       comparing the absolute difference in x and y coordinates, 
       the larger value is the minimum time need to travel between them;
	2. Sum these time.
    */
	
	/*
     * @param points: a list of 2D integer
     * @return: the minimum time in seconds to visit all the points in the order given by points
     */
	public static int minTimeToVisitAllPoints(int[][] points) {
       int ans = 0;
        for (int i = 1; i < points.length; ++i) {
            int[] cur = points[i], prev = points[i - 1];
            ans += Math.max(Math.abs(cur[0] - prev[0]), Math.abs(cur[1] - prev[1]));
        }
        return ans;   
    }

}
