package com.fixedPoint;
import java.util.*;

/*
Given an array of distinct integers arr, where arr is sorted 
in ascending order, return the smallest index i that satisfies 
arr[i] == i. If there is no such index, return -1.
*/

public class E1064_Fixed_Point {

	public static void main(String[] args) {
		E1064_Fixed_Point solution = new E1064_Fixed_Point();
		int[] input = {-10,-5,0,3,7};
		int output = solution.fixedPoint(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Binary Search: We use binary search to efficiently find the fixed point, where arr[i] == i.
	2. Left and Right Pointers: We initialize left and right pointers to the start and end of the array, respectively.
	3. Mid Calculation: Calculate the middle index mid in each iteration.
	4. Fixed Point Check:
	   . If arr[mid] == mid, it could be a fixed point. To find the smallest index, continue searching in the left half by setting right = mid - 1.
	   . If arr[mid] < mid, the fixed point must be in the right half, so set left = mid + 1.
	   . If arr[mid] > mid, the fixed point must be in the left half, so set right = mid - 1.
	5. Final Check: After the binary search loop, check if the left index is a valid fixed point.
	6. Return Result: Return the fixed point if found; otherwise, return -1.
    */
	
	/*
     * @param arr: a list of integers
     * @return: the smallest index i that satisfies arr[i] == i
     */
	public int fixedPoint(int[] arr) {
        // Initialize the left and right pointers for binary search
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == mid) {
                // If arr[mid] == mid, we found a fixed point, but we need the smallest index
                // So we continue searching in the left half
                right = mid - 1;
            } else if (arr[mid] < mid) {
                // If arr[mid] < mid, the fixed point must be in the right half
                left = mid + 1;
            } else {
                // If arr[mid] > mid, the fixed point must be in the left half
                right = mid - 1;
            }
        }

        // After binary search, check if left points to a valid fixed point
        if (left < arr.length && arr[left] == left) {
            return left;
        }

        // If no fixed point is found, return -1
        return -1;
    }

}
