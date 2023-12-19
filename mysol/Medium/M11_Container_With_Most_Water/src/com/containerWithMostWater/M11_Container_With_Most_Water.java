package com.containerWithMostWater;
import java.util.*;

/*
You are given an integer array height of length n. There are n vertical lines 
drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that 
the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
*/

public class M11_Container_With_Most_Water {

	public static void main(String[] args) {
		int[] input = {1,8,6,2,5,4,8,3,7};
		int output = maxArea(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Two Pointer Approach
    */
	
	/*
     * @param height: a list of integers
     * @return: the maximum amount of water a container can store
     */
	public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculating the area
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            // Updating the maximum area
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
