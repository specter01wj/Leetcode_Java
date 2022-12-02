package com.checkIfNandItsDoubleExist;
import java.util.*;

/*
Given an array arr of integers, check if there exist two indices i and j such that:

 .i != j
 .0 <= i, j < arr.length
 .arr[i] == 2 * arr[j]


Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

Example 2:

Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
*/

public class E1346_Check_If_N_and_Its_Double_Exist {

	public static void main(String[] args) {
		int[] input = {10,2,5,3};
		boolean output = checkIfExist(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();   
        for (int i : arr) {
            if (seen.contains(2 * i) || i % 2 == 0 && seen.contains(i / 2))
                return true;
            seen.add(i);
        }
        return false;
    }

}
