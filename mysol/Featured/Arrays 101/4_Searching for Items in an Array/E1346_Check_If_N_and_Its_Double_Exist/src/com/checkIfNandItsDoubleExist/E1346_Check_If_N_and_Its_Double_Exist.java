package com.checkIfNandItsDoubleExist;
import java.util.*;

/*
Given an array arr of integers, check if there exist two indices i and j such that :

  . i != j
  . 0 <= i, j < arr.length
  . arr[i] == 2 * arr[j]
*/

public class E1346_Check_If_N_and_Its_Double_Exist {

	public static void main(String[] args) {
		E1346_Check_If_N_and_Its_Double_Exist solution = new E1346_Check_If_N_and_Its_Double_Exist();
		int[] input = {10,2,5,3};
		boolean output = solution.checkIfExist(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. For each num in arr, check:
		. If 2 * num already exists in the set → arr[j] == 2 * arr[i].
		. If num is even and num / 2 exists → arr[i] == 2 * arr[j].
	2. Add num to the set afterward to avoid matching i == j.
    */
	
	/*
     * @param arr: a list of integers
     * @return: boolean
     */
	public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

}
