package com.validWordSquare;
import java.util.*;
import java.util.stream.Collectors;

/*
Given an array of strings words, return true if it forms a valid word square.

A sequence of strings forms a valid word square if the kth row and column 
read the same string, where 0 <= k < max(numRows, numColumns).
*/

public class E422_Valid_Word_Square {

	public static void main(String[] args) {
		List<String> input = List.of("abcd", "bnrt", "crmy", "dtye");
		boolean output = validWordSquare(input);
        System.out.println("input: " + listToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Iterate through each row
    */
	
	/*
     * @param arr: a list of string
     * @return: true if it forms a valid word square
     */
	public static boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
            return true;
        }
        
        int numRows = words.size();
        for (int i = 0; i < numRows; i++) {
            String row = words.get(i);
            for (int j = 0; j < row.length(); j++) {
                // Check if j-th row exists and is long enough
                if (j >= numRows || i >= words.get(j).length()) {
                    return false;
                }
                // Compare characters
                if (row.charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
	
	private static String listToString(List<String> list) {
        return list.stream()
                   .map(s -> "\"" + s + "\"")
                   .collect(Collectors.joining(",", "{", "}"));
    }

}
