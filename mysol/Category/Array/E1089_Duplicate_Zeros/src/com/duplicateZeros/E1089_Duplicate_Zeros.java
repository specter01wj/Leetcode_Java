package com.duplicateZeros;
import java.util.*;

/*
Given a fixed-length integer array arr, duplicate each occurrence 
of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are 
not written. Do the above modifications to the input array in place 
and do not return anything.


Example 1:

Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is 
modified to: [1,0,0,2,3,0,0,4]

Example 2:

Input: arr = [1,2,3]
Output: [1,2,3]
Explanation: After calling your function, the input array is 
modified to: [1,2,3]
*/

public class E1089_Duplicate_Zeros {

	public static void main(String[] args) {
		int[] input = {1,0,2,3,0,4,5,0};
		int[] output = duplicateZeros(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    Basically, we apply two pointers.
	i is the position in the original array,
	j is the position in the new array.
	(the original and the new are actually the same array.)
	
	The first we pass forward and count the zeros.
	The second we pass backward and assign the value from original input to the new array.
	so that the original value won't be overridden too early.
    */
	
	/*
     * @param arr: a list of integer
     * @return: duplicate each occurrence of zero, shifting the remaining elements to the right
     */
	public static int[] duplicateZeros(int[] arr_orig) {
		int[] arr = arr_orig.clone();
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countZero++;
            }
        }
        int len = arr.length + countZero;
        //We just need O(1) space if we scan from back
        //i point to the original array, j point to the new location
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
            } else {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
                j--;
                if (j < arr.length) {
                    arr[j] = arr[i]; //copy twice when hit '0'
                }
            }
        }
        
        return arr;
    }

}
