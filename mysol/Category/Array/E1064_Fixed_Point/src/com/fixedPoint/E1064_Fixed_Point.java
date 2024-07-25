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
