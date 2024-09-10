package com.oddStringDifference;
import java.util.*;

/*
You are given an array of equal-length strings words. 
Assume that the length of each string is n.

Each string words[i] can be converted into a difference integer 
array difference[i] of length n - 1 where difference[i][j] = 
words[i][j+1] - words[i][j] where 0 <= j <= n - 2. 
Note that the difference between two letters is the difference 
between their positions in the alphabet i.e. the position of 
'a' is 0, 'b' is 1, and 'z' is 25.

	. For example, for the string "acb", the difference integer array is [2 - 0, 1 - 2] = [2, -1].

All the strings in words have the same difference integer array, except one. 
You should find that string.

Return the string in words that has different difference integer array.
*/

public class E2451_Odd_String_Difference {

	public static void main(String[] args) {
		E2451_Odd_String_Difference solution = new E2451_Odd_String_Difference();
		String[] input = {"adc","wzy","abc"};
		String output = solution.oddString(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. computeDifferenceArray: This helper function computes the difference 
    	array for each word by calculating the difference between adjacent 
    	characters.
	2. areEqual: This helper function checks if two arrays are equal.
	3. oddString: This function loops through the list of words and compares 
		the difference arrays to find the unique one. If a difference array 
		doesn't match its neighbors, it returns the corresponding word.
    */
	
	/*
     * @param words: a list of strings
     * @return: the string in words that has different difference integer array
     */
	public String oddString(String[] words) {
        int n = words.length;
        int[][] diffs = new int[n][];
        
        // Compute difference array for each word
        for (int i = 0; i < n; i++) {
            diffs[i] = computeDifferenceArray(words[i]);
        }
        
        // Find the unique difference array
        for (int i = 0; i < n; i++) {
            // Check if the difference array is unique
            if (!areEqual(diffs[i], diffs[(i + 1) % n]) && !areEqual(diffs[i], diffs[(i + 2) % n])) {
                return words[i];
            }
        }
        
        return words[0];
    }

    private int[] computeDifferenceArray(String word) {
        int n = word.length();
        int[] diff = new int[n - 1];
        
        for (int i = 0; i < n - 1; i++) {
            diff[i] = word.charAt(i + 1) - word.charAt(i);
        }
        
        return diff;
    }

    private boolean areEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

}
