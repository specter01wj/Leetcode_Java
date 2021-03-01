package com.monotonicArray;
import java.util.*;

/*An array is monotonic if it is either monotone increasing or 
monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  
An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.

 

Example 1:

Input: [1,2,2,3]
Output: true

Example 2:

Input: [6,5,4,4]
Output: true

Example 3:

Input: [1,3,2]
Output: false

Example 4:

Input: [1,2,4,5]
Output: true

Example 5:

Input: [1,1,1]
Output: true*/

public class E896_Monotonic_Array {

	public static void main(String[] args) {
		int[] input = {1,2,4,5};
        boolean output = isMonotonic(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    先假设数组为单调递增，也为单调递减。遍历一遍数组，判断是否破坏了递增或递减的单调性。
    若递增或递减其中一种属性未被破坏，即始终为true，返回其中一种结果
    */
	
	/**
     * @param A: a array
     * @return: is it monotonous
     */
	public static boolean isMonotonic(int[] A) {
		boolean inc = true, dec = true;
		
		for(int i = 1; i < A.length; i++) {
			inc &= A[i - 1] <= A[i];
			dec &= A[i - 1] >= A[i];
		}
		
		return inc || dec;
	}

}
