package com.sortArrayByParity;
import java.util.*;

/*Given an array A of non-negative integers, return an array 
consisting of all the even elements of A, followed by all 
the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.*/

public class E905_Sort_Array_By_Parity {

	public static void main(String[] args) {
		int[] input = {3,1,2,4};
		System.out.println("input: " + Arrays.toString(input));
        int[] output = sortArrayByParity(input);
        System.out.println("output: " + Arrays.toString(output));
	}
	
	/*
    solution:
    使用双指针：一个奇数指针，指向奇数位；一个偶数指针，指向偶数位
    */
	
	/**
     * @param A: 
     * @return: Sort Array By Parity
     */
	public static int[] sortArrayByParity(int[] A) {
		for(int i = 0, j = 0; j < A.length; j++) {
			if(A[j] % 2 == 0) {
				int tmp = A[i];
				A[i++] = A[j];
				A[j] = tmp;
			}
		}
		
		return A;
	}

}
