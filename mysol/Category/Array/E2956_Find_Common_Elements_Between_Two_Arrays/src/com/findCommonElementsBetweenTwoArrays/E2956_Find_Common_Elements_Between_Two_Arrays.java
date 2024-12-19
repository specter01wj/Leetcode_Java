package com.findCommonElementsBetweenTwoArrays;
import java.util.*;

/*
You are given two integer arrays nums1 and nums2 of sizes n and m, respectively. 
Calculate the following values:

	. answer1 : the number of indices i such that nums1[i] exists in nums2.
	. answer2 : the number of indices i such that nums2[i] exists in nums1.

Return [answer1,answer2].
*/

public class E2956_Find_Common_Elements_Between_Two_Arrays {

	public static void main(String[] args) {
		E2956_Find_Common_Elements_Between_Two_Arrays solution = new E2956_Find_Common_Elements_Between_Two_Arrays();
		int[] input1 = {4,3,2,3,1}, input2 = {2,2,5,2,3,6};
		int[] output = solution.findIntersectionValues(input1, input2);
        System.out.println("input: " + Arrays.toString(input1) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        // Create sets to store the elements of each array
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Add elements from nums2 into set2 for fast lookup
        for (int num : nums2) {
            set2.add(num);
        }
        
        int answer1 = 0; // Count of indices i such that nums1[i] exists in nums2
        for (int num : nums1) {
            if (set2.contains(num)) {
                answer1++;
            }
            set1.add(num); // Add to set1 while iterating
        }
        
        int answer2 = 0; // Count of indices i such that nums2[i] exists in nums1
        for (int num : nums2) {
            if (set1.contains(num)) {
                answer2++;
            }
        }
        
        return new int[]{answer1, answer2};
    }

}
