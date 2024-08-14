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
	
	/*
    solution:
    1. Initialization:
		. A boolean changed is set to true to start the while loop that 
			will continue until no changes occur in the array.
		. A temporary array temp is created to store the intermediate 
			results of the transformation.
	2. Transformation Process:
		. For each element (excluding the first and last), check if it is 
			smaller than both its neighbors or larger than both its neighbors.
		. If the element is smaller than both its neighbors, increment it; 
			if it's larger, decrement it.
		. Set changed to true if any modification was made during the iteration.
	3. Loop Until Stable:
		. The process repeats until the array no longer changes (changed remains false).
	4. Conversion to List:
		. The final array is converted into a List<Integer> and returned.
    */
	
	/*
     * @param arr: a list of integers
     * @return: that final array
     */
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
