package com.sortArrayByParity;
import java.util.*;

/*
Given an integer array nums, move all the even integers at the beginning of 
the array followed by all the odd integers.

Return any array that satisfies this condition.
*/

public class E905_Sort_Array_By_Parity {

	public static void main(String[] args) {
		E905_Sort_Array_By_Parity solution = new E905_Sort_Array_By_Parity();
		int[] input = {3,1,2,4};
		int[] inputCopy = Arrays.copyOf(input, input.length);
		int[] output = solution.sortArrayByParity(inputCopy);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;

        while (left < right) {
            if (A[left] % 2 > A[right] % 2) {
                // Swap A[left] and A[right]
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }

            if (A[left] % 2 == 0) left++;
            if (A[right] % 2 == 1) right--;
        }

        return A;
    }

}
