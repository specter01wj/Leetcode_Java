package com.replaceElementswithGreatestElementonRightSide;
import java.util.*;

/*
Given an array arr, replace every element in that array with the greatest 
element among the elements to its right, and replace the last element with -1.

After doing so, return the array.
*/

public class E1299_Replace_Elements_with_Greatest_Element_on_Right_Side {

	public static void main(String[] args) {
		E1299_Replace_Elements_with_Greatest_Element_on_Right_Side solution = new E1299_Replace_Elements_with_Greatest_Element_on_Right_Side();
		int[] input = {17,18,5,4,6,1};
		int[] output = solution.replaceElements(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int maxRight = -1;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = maxRight;
            if (current > maxRight) {
                maxRight = current;
            }
        }

        return arr;
    }

}
