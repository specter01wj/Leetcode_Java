package com.determineifStringHalvesAreAlike;
import java.util.*;

/*
You are given a string s of even length. Split this string into two halves 
of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels 
('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). 
Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.


Example 1:

Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. 
Therefore, they are alike.

Example 2:

Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. 
Therefore, they are not alike.
Notice that the vowel o is counted twice.
*/

public class E1704_Determine_if_String_Halves_Are_Alike {

	public static void main(String[] args) {
		String input = "book";
		boolean output = halvesAreAlike(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Use Set to check equality.
    */
	
	/**
     * @param s: a string
     * @return: true if a and b are alike
     */
	public static boolean halvesAreAlike(String s) {
        var vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int a = 0, b = 0;
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            a += vowels.contains(s.charAt(i)) ? 1 : 0;
            b += vowels.contains(s.charAt(j)) ? 1 : 0;
        }
        return a == b;
    }

}
