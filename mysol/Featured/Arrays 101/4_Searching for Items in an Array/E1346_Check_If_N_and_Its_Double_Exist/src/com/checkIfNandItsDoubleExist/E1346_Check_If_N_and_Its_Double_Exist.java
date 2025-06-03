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
		int[] input = {10,2,5,3};
		int output = checkIfExist(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
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
