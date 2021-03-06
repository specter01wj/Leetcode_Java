package com.addtoArrayFormofInteger;
import java.util.*;

/*For a non-negative integer X, the array-form of X is an array 
of its digits in left to right order.  For example, if X = 1231, 
then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return 
the array-form of the integer X+K.

 

Example 1:

Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234

Example 2:

Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455

Example 3:

Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021

Example 4:

Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000*/

public class E989_Add_to_ArrayForm_of_Integer {

	public static void main(String[] args) {
		int[] input = {2,1,5};
        List<Integer> output = addToArrayForm(input, 806);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Take K as a carry.
	Add it to the lowest digit,
	Update carry K,
	and keep going to higher digit.
    */
	
	/*
     * @param A: a list of integers
     * @param K: an integer
     * @return: array-form of the integer X+K
     */
	public static List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> res = new LinkedList<>();
		
		for(int i = A.length - 1; i >= 0; i--) {
			res.add(0, (A[i] + K) % 10);
			K = (A[i] + K) / 10;
		}
		while(K > 0) {
			res.add(0, K % 10);
			K /= 10;
		}
		
		return res;
	}

}
