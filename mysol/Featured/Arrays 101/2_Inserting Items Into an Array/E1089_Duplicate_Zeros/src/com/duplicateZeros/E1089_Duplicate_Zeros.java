package com.duplicateZeros;
import java.util.*;

/*
Given a fixed-length integer array arr, duplicate each occurrence of zero, 
shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written. 
Do the above modifications to the input array in place and do not return anything.
*/

public class E1089_Duplicate_Zeros {

	public static void main(String[] args) {
		E1089_Duplicate_Zeros solution = new E1089_Duplicate_Zeros();
		int[] input = {1,0,2,3,0,4,5,0};
		int[] inputCopy = Arrays.copyOf(input, input.length);
		solution.duplicateZeros(inputCopy);
		int[] output = inputCopy;
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. First loop: Count how many zeros can be duplicated without exceeding array bounds.
	2. Second loop (reverse): Shift elements to the right from the back, duplicating zeros as needed.
    */
	
	/*
     * @param arr: a list of integers
     * @return: void
     */
	public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int possibleDups = 0;
        int last = n - 1;

        // Count the number of zeros to be duplicated
        for (int i = 0; i <= last - possibleDups; i++) {
            if (arr[i] == 0) {
                // Edge case: zero at the boundary
                if (i == last - possibleDups) {
                    arr[last] = 0;
                    last--;
                    break;
                }
                possibleDups++;
            }
        }

        // Start from the end and shift
        for (int i = last - possibleDups; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }

}
