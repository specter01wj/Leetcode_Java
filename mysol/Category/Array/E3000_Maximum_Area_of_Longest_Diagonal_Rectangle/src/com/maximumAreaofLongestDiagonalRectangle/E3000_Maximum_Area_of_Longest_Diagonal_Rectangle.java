package com.maximumAreaofLongestDiagonalRectangle;
import java.util.*;

/*
You are given a 2D 0-indexed integer array dimensions.

For all indices i, 0 <= i < dimensions.length, dimensions[i][0] 
represents the length and dimensions[i][1] represents the width 
of the rectangle i.

Return the area of the rectangle having the longest diagonal. 
If there are multiple rectangles with the longest diagonal, 
return the area of the rectangle having the maximum area.
*/

public class E3000_Maximum_Area_of_Longest_Diagonal_Rectangle {

	public static void main(String[] args) {
		E3000_Maximum_Area_of_Longest_Diagonal_Rectangle solution = new E3000_Maximum_Area_of_Longest_Diagonal_Rectangle();
		int[][] input = {{9,3},{8,6}};
		int output = solution.areaOfMaxDiagonal(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0;
        int maxArea = 0;

        for (int[] rectangle : dimensions) {
            int length = rectangle[0];
            int width = rectangle[1];

            // Calculate the diagonal length using the Pythagorean theorem
            double diagonal = Math.sqrt(length * length + width * width);

            // Calculate the area of the rectangle
            int area = length * width;

            // Update the maximum diagonal and area based on the conditions
            if (diagonal > maxDiagonal || (diagonal == maxDiagonal && area > maxArea)) {
                maxDiagonal = diagonal;
                maxArea = area;
            }
        }

        return maxArea;
    }

}
