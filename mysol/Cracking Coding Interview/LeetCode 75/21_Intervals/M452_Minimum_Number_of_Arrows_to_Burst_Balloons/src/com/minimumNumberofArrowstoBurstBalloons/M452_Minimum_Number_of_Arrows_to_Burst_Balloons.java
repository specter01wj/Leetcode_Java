package com.minimumNumberofArrowstoBurstBalloons;
import java.util.*;

/*
There are some spherical balloons taped onto a flat wall that represents 
the XY-plane. The balloons are represented as a 2D integer array points 
where points[i] = [xstart, xend] denotes a balloon whose horizontal 
diameter stretches between xstart and xend. You do not know the exact 
y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) 
from different points along the x-axis. A balloon with xstart and xend 
is burst by an arrow shot at x if xstart <= x <= xend. There is no limit 
to the number of arrows that can be shot. A shot arrow keeps traveling up 
infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be 
shot to burst all balloons.
*/

public class M452_Minimum_Number_of_Arrows_to_Burst_Balloons {

	public static void main(String[] args) {
		int[][] input = {{10,16},{2,8},{1,6},{7,12}};
		int output = findMinArrowShots(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Intervals
    */
	
	/*
     * @param points: a list of 2D integers
     * @return: the minimum number of arrows that must be shot to burst all balloons
     */
	public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        // Sort the points based on the end position
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1; // Start with one arrow
        int arrowPos = points[0][1]; // Position of the arrow is at the end of the first balloon
        
        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the last arrow position,
            // it means we need another arrow for this balloon
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1]; // Update the arrow position to the end of the current balloon
            }
            // If the current balloon starts before or at the last arrow position,
            // it is already burst by the current arrow, so we do nothing
        }
        
        return arrows;
    }

}
