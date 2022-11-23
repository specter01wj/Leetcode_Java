package com.replaceElementswithGreatestElementonRightSide;
import java.util.*;

/*
Given an array arr, replace every element in that array with the greatest 
element among the elements to its right, and replace the last element with -1.

After doing so, return the array.


Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation: 
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.
Example 2:

Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.
*/

public class E1299_Replace_Elements_with_Greatest_Element_on_Right_Side {

	public static void main(String[] args) {
		int[] input = {17,18,5,4,6,1};
		int[] output = replaceElements(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    Iterate from the back to the start,
	We initilize mx = -1, where mx represent the max on the right.
	Each round, we set A[i] = mx, where mx is its mas on the right.
	Also we update mx = max(mx, A[i]), where A[i] is its original value.
    */
	
	/*
     * @param arr: a list of integers
     * @return: an array
     */
	public static int[] replaceElements(int[] arr) {
		int[] arr_tmp = arr.clone();
        for (int i = arr_tmp.length - 1, mx = -1; i >= 0; --i) {
            mx = Math.max(arr_tmp[i], arr_tmp[i] = mx);
        }
        return arr_tmp;
    }

}
