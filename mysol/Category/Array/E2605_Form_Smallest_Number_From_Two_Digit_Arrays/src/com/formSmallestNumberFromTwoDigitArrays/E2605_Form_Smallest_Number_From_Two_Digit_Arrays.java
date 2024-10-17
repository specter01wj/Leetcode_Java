package com.formSmallestNumberFromTwoDigitArrays;
import java.util.*;

/*
Given two arrays of unique digits nums1 and nums2, return the 
smallest number that contains at least one digit from each array.
*/

public class E2605_Form_Smallest_Number_From_Two_Digit_Arrays {

	public static void main(String[] args) {
		E2605_Form_Smallest_Number_From_Two_Digit_Arrays solution = new E2605_Form_Smallest_Number_From_Two_Digit_Arrays();
		int[] nums1 = {4,1,3}, nums2 = {5,7};
		int output = solution.minNumber(nums1, nums2);
        System.out.println("input1: " + Arrays.toString(nums1) + 
        		"; input2: " + Arrays.toString(nums2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Common digit check: use a HashSet to store all digits from nums1. 
    	Then, check each digit from nums2 to see if it's in the set. 
    	If find a common digit, return the smallest one.
	2. No common digit: If there's no common digit, find the smallest digit 
		from each array and form the smallest possible two-digit number by 
		combining them.
    */
	
	/*
     * @param nums1: a list of integers
     * @param nums2: a list of integers
     * @return: the smallest number that contains at least one digit from each array
     */
	public int minNumber(int[] nums1, int[] nums2) {
        // Step 1: Find the smallest common digit
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        int smallestCommon = Integer.MAX_VALUE;
        for (int num : nums2) {
            if (set.contains(num)) {
                smallestCommon = Math.min(smallestCommon, num);
            }
        }
        if (smallestCommon != Integer.MAX_VALUE) {
            return smallestCommon; // Found common digit, return it
        }

        // Step 2: No common digit, return smallest combination
        int minNum1 = Arrays.stream(nums1).min().getAsInt();
        int minNum2 = Arrays.stream(nums2).min().getAsInt();
        
        // Form the smallest two-digit number
        return Math.min(minNum1 * 10 + minNum2, minNum2 * 10 + minNum1);
    }

}
