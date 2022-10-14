package com.relativeSortArray;
import java.util.*;

/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, 
and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items 
in arr1 are the same as in arr2. Elements that do not appear in arr2 
should be placed at the end of arr1 in ascending order.


Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

Example 2:

Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]
*/

public class E1122_Relative_Sort_Array {

	public static void main(String[] args) {
		int[] input1 = {2,3,1,3,2,4,6,7,9,2,19}, input2 = {2,1,4,3,9,6};
		int[] output = relativeSortArray(input1, input2);
        System.out.println("input1: " + Arrays.toString(input1) + " input2: " + Arrays.toString(input2) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public static int[] relativeSortArray(int[] arr1_orig, int[] arr2) {
		int[] arr1 = arr1_orig.clone();
        int[] cnt = new int[1001];
        for(int n : arr1) {
            cnt[n]++;
        }
        int i = 0;
        for(int n : arr2) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for(int n = 0; n < cnt.length; n++) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }

}
