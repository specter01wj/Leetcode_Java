package com.minimumCommonValue;
import java.util.*;

/*
Given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
return the minimum integer common to both arrays. If there is no common 
integer amongst nums1 and nums2, return -1.

Note that an integer is said to be common to nums1 and nums2 if both arrays 
have at least one occurrence of that integer.


Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4]
Output: 2
Explanation: The smallest element common to both arrays is 2, so we return 2.

Example 2:

Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
Output: 2
Explanation: There are two common elements in the array 2 and 3 out of which 2 
is the smallest, so 2 is returned.
*/

public class E2540_Minimum_Common_Value {

	public static void main(String[] args) {
		E2540_Minimum_Common_Value solution = new E2540_Minimum_Common_Value();
		int[] nums1 = {1,2,3}, nums2 = {2,4};
		int output = solution.getCommon(nums1, nums2);
        System.out.println("input1: " + Arrays.toString(nums1) + 
        		"; input2: " + Arrays.toString(nums2) + "\noutput: " + (output));
	}
	
	
	public int getCommon(int[] nums1, int[] nums2) {
		int i = 0, j = 0;
        
        // Use two pointers to traverse through both arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]; // Common element found
            } else if (nums1[i] < nums2[j]) {
                i++; // Move pointer of nums1 forward
            } else {
                j++; // Move pointer of nums2 forward
            }
        }
        
        return -1; // No common element found
	}

}
