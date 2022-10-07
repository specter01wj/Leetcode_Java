package com.generateaStringWithCharactersThatHaveOddCounts;
import java.util.*;




public class E1374_Generate_a_String_With_Characters_That_Have_Odd_Counts {

	public static void main(String[] args) {
		int input = 4;
        String output = generateTheString(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    opened count the number of opened parenthesis.
	Add every char to the result,
	unless the first left parenthesis,
	and the last right parenthesis.
    */
	
	/**
     * @param s: a string
     * @return: after removing the outermost parentheses
     */
	public static String generateTheString(int n) {
		// need Java11
        //return "b" + "ab".substring(n % 2, 1 + n % 2).repeat(n - 1);
		char[] str = new char[n];
	    Arrays.fill(str, 'a');
	    if(n % 2 == 0) {
	        str[0] = 'b';
	    }
	    return new String(str);
    }

}
