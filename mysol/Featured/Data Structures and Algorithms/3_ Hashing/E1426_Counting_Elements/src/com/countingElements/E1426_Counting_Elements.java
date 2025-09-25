package com.countingElements;
import java.util.*;

/*
Given an integer array arr, count how many elements x there are, 
such that x + 1 is also in arr. If there are duplicates in arr, 
count them separately.
*/

public class E1426_Counting_Elements {

	public static void main(String[] args) {
		E1426_Counting_Elements solution = new E1426_Counting_Elements();
		int[] input = {1,2,3};
		int output = solution.countElements(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int countElements(int[] arr) {
		Set<Integer> set = new HashSet<>();
		
		for (int num : arr) {
			set.add(num);
		}
		
		int count = 0;
		for (int num : arr) {
			if (set.contains(num + 1)) {
				count++;
			}
		}
		
		return count;
	}

}
