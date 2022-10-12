package com.validBoomerang;
import java.util.*;

/*
Given an array points where points[i] = [xi, yi] represents 
a point on the X-Y plane, return true if these points are a boomerang.

A boomerang is a set of three points that are all distinct and not 
in a straight line.


Example 1:

Input: points = [[1,1],[2,3],[3,2]]
Output: true

Example 2:

Input: points = [[1,1],[2,2],[3,3]]
Output: false
*/

public class E1037_Valid_Boomerang {

	public static void main(String[] args) {
		int[][] input = {{1,1},{2,3},{3,2}};
		boolean output = isBoomerang(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public static boolean isBoomerang(int[][] points) {
        return (points[0][0] - points[1][0]) * (points[0][1] - points[2][1]) != (points[0][0] - points[2][0]) * (points[0][1] - points[1][1]);
    }

}
