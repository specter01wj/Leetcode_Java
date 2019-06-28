package com.E387_First_Unique_Character_in_a_String;

import java.util.*;

/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
*/

public class E387_First_Unique_Character_in_a_String {

	public static void main(String[] args) {
		String input = "loveleetcode";
        int output = firstUniqChar(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Approach 1: Linear time solution
	The best possible solution here could be of a linear time because to 
	ensure that the character is unique you have to check the whole string anyway.
	
	The idea is to go through the string and save in a hash map the number of 
	times each character appears in the string. That would take O(N) time, 
	where N is a number of characters in the string.
	
	And then we go through the string the second time, this time we use the 
	hash map as a reference to check if a character is unique or not.
	If the character is unique, one could just return its index. 
	The complexity of the second iteration is O(N) as well.
    */
	
	/*
     * @param s: a string
     * @return: integer, the first unique character in a given string
     */
	public static int firstUniqChar(String s) {
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			char c = s.charAt(i);
			count.put(c, count.getOrDefault(c, 0) + 1);
		}
		
		for(int i = 0; i < n; i++) {
			if(count.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		
		return -1;
	}

}
