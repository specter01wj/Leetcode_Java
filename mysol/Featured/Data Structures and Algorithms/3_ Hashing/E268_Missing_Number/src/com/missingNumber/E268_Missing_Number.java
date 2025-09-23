package com.missingNumber;
import java.util.*;

/*
Given an array nums containing n distinct numbers in the range [0, n], 
return the only number in the range that is missing from the array.
*/

public class E268_Missing_Number {

	public static void main(String[] args) {
		E268_Missing_Number solution = new E268_Missing_Number();
		int[] input = {9,6,4,2,3,5,7,0,1};
		int output = solution.missingNumber(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashSet
    */
	
	/*
     * @param nums: a list of integers
     * @return: the only number in the range that is missing from the array
     */
	public int missingNumber(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		
		for (int num : nums) {
			seen.add(num);
		}
		
		int n = nums.length;
		for (int i = 0; i <= n; i++) {
			if (!seen.contains(i)) {
				return i;
			}
		}
		
		return -1;
	}

}
