package com.distributeElementsIntoTwoArraysI;
import java.util.*;

/*
You are given a 1-indexed array of distinct integers nums of length n.

You need to distribute all the elements of nums between two arrays arr1 
and arr2 using n operations. In the first operation, append nums[1] to arr1. 
In the second operation, append nums[2] to arr2. Afterwards, in the ith operation:

	. If the last element of arr1 is greater than the last element of arr2, 
		append nums[i] to arr1. Otherwise, append nums[i] to arr2.

The array result is formed by concatenating the arrays arr1 and arr2. 
For example, if arr1 == [1,2,3] and arr2 == [4,5,6], then result = [1,2,3,4,5,6].

Return the array result.
*/

public class E3069_Distribute_Elements_Into_Two_Arrays_I {

	public static void main(String[] args) {
		E3069_Distribute_Elements_Into_Two_Arrays_I solution = new E3069_Distribute_Elements_Into_Two_Arrays_I();
		int[] input = {5,4,3,8};
		int[] output = solution.resultArray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // Add the first element to arr1 and the second element to arr2
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        // Start from the third element
        for (int i = 2; i < nums.length; i++) {
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // Combine arr1 and arr2 into the result array
        int[] result = new int[nums.length];
        int index = 0;
        for (int num : arr1) {
            result[index++] = num;
        }
        for (int num : arr2) {
            result[index++] = num;
        }

        return result;
    }

}
