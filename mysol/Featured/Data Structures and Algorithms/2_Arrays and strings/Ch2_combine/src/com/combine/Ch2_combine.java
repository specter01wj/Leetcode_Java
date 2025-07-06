package com.combine;
import java.util.*;

/*
Example 3: Given two sorted integer arrays arr1 and arr2, 
return a new array that combines both of them and is also sorted.
*/

public class Ch2_combine {

	public static void main(String[] args) {
		Ch2_combine solution = new Ch2_combine();
		int[] input1 = {1, 4, 7, 20};
		int[] input2 = {3, 5, 6};
		List<Integer> output = solution.combine(input1, input2);
        System.out.println("input: " + Arrays.toString(input1) + "\noutput: " + (output));
	}
	
	
	public List<Integer> combine(int[] arr1, int[] arr2) {
	    // ans is the answer
	    List<Integer> ans = new ArrayList<>();
	    int i = 0;
	    int j = 0;

	    while (i < arr1.length && j < arr2.length) {
	        if (arr1[i] < arr2[j]) {
	            ans.add(arr1[i]);
	            i++;
	        } else {
	            ans.add(arr2[j]);
	            j++;
	        }
	    }

	    while (i < arr1.length) {
	        ans.add(arr1[i]);
	        i++;
	    }

	    while (j < arr2.length) {
	        ans.add(arr2[j]);
	        j++;
	    }

	    return ans;
	}

}
