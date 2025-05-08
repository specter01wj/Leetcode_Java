package com.phoneNumberPrefix;
import java.util.*;

/*
You are given a string array numbers that represents phone numbers. 
Return true if no phone number is a prefix of any other phone number; 
otherwise, return false.
*/

public class E3491_Phone_Number_Prefix {

	public static void main(String[] args) {
		E3491_Phone_Number_Prefix solution = new E3491_Phone_Number_Prefix();
		String[] input = {"001","007","15","00153"};
		boolean output = solution.phonePrefix(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public boolean phonePrefix(String[] numbers) {
        // Step 1: Sort the array to bring prefix-close strings adjacent
        Arrays.sort(numbers);

        // Step 2: Compare each number with the next one in the sorted array
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1].startsWith(numbers[i])) {
                return false;
            }
        }

        return true;
    }

}
