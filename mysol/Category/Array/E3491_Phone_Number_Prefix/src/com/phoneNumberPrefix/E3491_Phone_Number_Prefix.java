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
	
	/*
    solution:
    1. Why Sorting Helps:
		. Sorting places strings with common prefixes next to each other.
		. For example, ["001", "00153"] will be adjacent after sorting.
	2. Iterate Through Sorted Array:
		. Only need to compare numbers[i] with numbers[i+1] since any prefix relationship would now be next to each other.
	3. Use startsWith():
		. This built-in method checks if one string is a prefix of another.
	4. Return Early:
		. As soon as a prefix is found, return false.
	5. Final Check:
		. If loop finishes without finding any prefix, return true.
    */
	
	/*
     * @param numbers: a list of strings
     * @return: true if no phone number is a prefix of any other phone number
     */
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
