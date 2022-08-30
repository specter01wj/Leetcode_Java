package com.largestTriangleArea;
import java.util.*;

/*
Given an array of points on the X-Y plane points where points[i] = [xi, yi], 
return the area of the largest triangle that can be formed by any three 
different points. Answers within 10-5 of the actual answer will be accepted.


Example 1:


Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2.00000
Explanation: The five points are shown in the above figure. 
The red triangle is the largest.

Example 2:

Input: points = [[1,0],[0,0],[0,1]]
Output: 0.50000
*/

public class E812_Largest_Triangle_Area {

	public static void main(String[] args) {
		int[][] input = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        double output = largestTriangleArea(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    由于点最多只有50个，直接枚举所有三角形即可。我们使用叉积计算三角形面积。
    */
	
	/**
     * @param points: List[List[int]]
     * @return: return a double
     */
	public static double largestTriangleArea(int[][] points) {
		double max = 0.0; 
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    max = Math.max(max, areaCal(points[i], points[j], points[k])); 
                }
            }
        }
        
        return max; 
	}
	
	public static double areaCal(int[] pt1, int[] pt2, int[] pt3) {
        return Math.abs(pt1[0] * (pt2[1] - pt3[1]) + pt2[0] * (pt3[1] - pt1[1]) + pt3[0] * (pt1[1] - pt2[1])) / 2.0; 
    }

}
