package com.decryptStringfromAlphabettoIntegerMapping;
import java.util.*;

/*
You are given a string s formed by digits and '#'. 
We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

The test cases are generated so that a unique mapping will always exist.


Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

Example 2:

Input: s = "1326#"
Output: "acz"
*/

public class E1309_Decrypt_String_from_Alphabet_to_Integer_Mapping {

	public static void main(String[] args) {
		String input = "10#11#12";
        String output = freqAlphabets(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    use HashMap
    */
	
	/**
     * @param s: a string
     * @return: the string formed after mapping
     */
	public static String freqAlphabets(String s) {
		HashMap<String, Character> map = new HashMap<>();
        int k = 1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch < 'j') {
                map.put(String.valueOf(k++), ch);
            } else {
                map.put(String.valueOf(k++)+"#", ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                sb.append(map.get(s.substring(i - 2, i+1)));
                i -= 3;
            } else {
                sb.append(map.get(s.substring(i, i + 1)));
                i--;
            }
        }
        
        return sb.reverse().toString(); 
    }

}
