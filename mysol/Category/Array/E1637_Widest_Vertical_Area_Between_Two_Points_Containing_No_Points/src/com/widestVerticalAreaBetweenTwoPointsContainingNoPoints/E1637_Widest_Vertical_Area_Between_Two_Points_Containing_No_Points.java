package com.widestVerticalAreaBetweenTwoPointsContainingNoPoints;
import java.util.*;

/*
Given n points on a 2D plane where points[i] = [xi, yi], 
Return the widest vertical area between two points such that 
no points are inside the area.

A vertical area is an area of fixed-width extending infinitely 
along the y-axis (i.e., infinite height). The widest vertical area 
is the one with the maximum width.

Note that points on the edge of a vertical area are not considered 
included in the area.
*/

public class E1637_Widest_Vertical_Area_Between_Two_Points_Containing_No_Points {

	public static void main(String[] args) {
		E1637_Widest_Vertical_Area_Between_Two_Points_Containing_No_Points solution = new E1637_Widest_Vertical_Area_Between_Two_Points_Containing_No_Points();
		int[][] input = {{8,7},{9,9},{7,4},{9,7}};
		int output = solution.maxWidthOfVerticalArea(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    . Extracting x-coordinates: We iterate through each point and store the x-coordinate in an array.
	. Sorting: sort the x-coordinates to find the consecutive points that will give us the possible widths of vertical areas.
	. Finding the maximum gap: We loop through the sorted array of x-coordinates and calculate the difference between each 
		pair of consecutive elements. The maximum difference gives us the widest vertical area.
    */
	
	/*
     * @param points: a list of 2D integers
     * @return: the widest vertical area between two points such that no points are inside the area
     */
	public int maxWidthOfVerticalArea(int[][] points) {
        // Extract the x-coordinates from the points
        int n = points.length;
        int[] xCoords = new int[n];
        for (int i = 0; i < n; i++) {
            xCoords[i] = points[i][0];
        }
        
        // Sort the x-coordinates
        Arrays.sort(xCoords);
        
        // Find the maximum gap between consecutive x-coordinates
        int maxWidth = 0;
        for (int i = 1; i < n; i++) {
            int gap = xCoords[i] - xCoords[i - 1];
            if (gap > maxWidth) {
                maxWidth = gap;
            }
        }
        
        return maxWidth;
    }

}
