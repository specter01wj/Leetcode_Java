package com.mergeSortedArray;
import java.util.*;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be 
stored inside the array nums1. To accommodate this, nums1 has a length of m + n, 
where the first m elements denote the elements that should be merged, and the 
last n elements are set to 0 and should be ignored. nums2 has a length of n.
*/

public class E88_Merge_Sorted_Array {

	public static void main(String[] args) {
		E88_Merge_Sorted_Array solution = new E88_Merge_Sorted_Array();
		int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
		int m = 3, n = 3;
		int[] inputCopy = Arrays.copyOf(nums1, nums1.length);
		solution.merge(inputCopy, m, nums2, n);
		int[] output = inputCopy;
        System.out.println("input1: " + Arrays.toString(nums1) + "; input2: " + Arrays.toString(nums2) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    count good triplets
    */
	
	/*
     * @param arr: a list of integers
     * @param a: an integer
     * @param b: an integer
     * @param c: an integer
     * @return: void
     */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;           // Pointer for nums1
        int p2 = n - 1;           // Pointer for nums2
        int p = m + n - 1;        // Pointer for placement in nums1

        // Merge from the end to the beginning
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If there are remaining elements in nums2
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

}
