package com.performStringShifts;
import java.util.*;

/*
You are given a string s containing lowercase English letters, 
and a matrix shift, where shift[i] = [directioni, amounti]:

	. directioni can be 0 (for left shift) or 1 (for right shift).
	. amounti is the amount by which string s is to be shifted.
	. A left shift by 1 means remove the first character of s and append it to the end.
	. Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.

Return the final string after all operations.
*/

public class E1427_Perform_String_Shifts {

	public static void main(String[] args) {
		E1427_Perform_String_Shifts solution = new E1427_Perform_String_Shifts();
		String input = "abc";
		int[][] shift = {{0, 1}, {1, 2}};
		String output = solution.stringShift(input, shift);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public String stringShift(String s, int[][] shift) {
        int totalShift = 0;

        // Calculate the net shift amount
        for (int[] operation : shift) {
            int direction = operation[0];
            int amount = operation[1];

            // Left shift
            if (direction == 0) {
                totalShift -= amount;
            }
            // Right shift
            else {
                totalShift += amount;
            }
        }

        // Reduce totalShift to a value within the string length
        int len = s.length();
        totalShift %= len;

        // Handle negative shifts by converting them to positive shifts
        if (totalShift < 0) {
            totalShift += len;
        }

        // Perform the final shift
        return s.substring(len - totalShift) + s.substring(0, len - totalShift);
    }

}
