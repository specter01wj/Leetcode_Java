package com.arrayTransformation;
import java.util.*;

/*
Given an initial array arr, every day you produce a new array 
using the array of the previous day.

On the i-th day, you do the following operations on the array 
of day i-1 to produce the array of day i:

1. If an element is smaller than both its left neighbor and its 
	right neighbor, then this element is incremented.
2. If an element is bigger than both its left neighbor and its 
	right neighbor, then this element is decremented.
3. The first and last elements never change.

After some days, the array does not change. Return that final array.
*/

public class E1243_Array_Transformation {

	public static void main(String[] args) {
		E1243_Array_Transformation solution = new E1243_Array_Transformation();
		int[] input = {6,2,3,4};
		List<Integer> output = solution.transformArray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public List<Integer> transformArray(int[] arr) {
        int n = arr.length;
        boolean changed = true;

        while (changed) {
            changed = false;
            int[] temp = Arrays.copyOf(arr, n);
            for (int i = 1; i < n - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    temp[i]++;
                    changed = true;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    temp[i]--;
                    changed = true;
                }
            }
            arr = temp;
        }

        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            result.add(num);
        }

        return result;
    }

}
