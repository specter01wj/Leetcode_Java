package com.maximumValueofaStringinanArray;
import java.util.*;

/*
The value of an alphanumeric string can be defined as:

	. The numeric representation of the string in base 10, if it comprises of digits only.
	. The length of the string, otherwise.

Given an array strs of alphanumeric strings, return the maximum value of any string in strs.
*/

public class E2496_Maximum_Value_of_a_String_in_an_Array {

	public static void main(String[] args) {
		E2496_Maximum_Value_of_a_String_in_an_Array solution = new E2496_Maximum_Value_of_a_String_in_an_Array();
		String[] input = {"alic3","bob","3","4","00000"};
		int output = solution.maximumValue(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. The method maximumValue iterates through each string in the array strs.
	2. For each string, it checks whether the string is composed entirely of digits using the regex \\d+.
	3. If the string contains only digits, it is converted to an integer using Integer.parseInt.
	4. If the string contains non-digit characters, its value is considered to be its length.
	5. The maxValue is updated if the current string's value is greater than the previous maximum.
	6. Finally, the method returns the maximum value found.
    */
	
	/*
     * @param strs: a list of strings
     * @return: the maximum value of any string in strs
     */
	public int maximumValue(String[] strs) {
        int maxValue = 0;
        
        for (String str : strs) {
            int currentValue;
            
            // Check if the string is composed only of digits
            if (str.matches("\\d+")) {
                // Convert string to its numeric value
                currentValue = Integer.parseInt(str);
            } else {
                // Otherwise, the value is the length of the string
                currentValue = str.length();
            }
            
            // Update maxValue if the current value is greater
            maxValue = Math.max(maxValue, currentValue);
        }
        
        return maxValue;
    }

}
