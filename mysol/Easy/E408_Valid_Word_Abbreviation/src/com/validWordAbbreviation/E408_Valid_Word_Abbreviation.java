package com.validWordAbbreviation;
import java.util.*;

/*Given a non-empty string s and an abbreviation abbr, 
return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", 
 "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Notice that only the above abbreviations are valid abbreviations of 
the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only 
lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.

Example 2:
Given s = "apple", abbr = "a2e":

Return false.*/

public class E408_Valid_Word_Abbreviation {

	public static void main(String[] args) {
		String input = "internationalization";
		String abbr = "i12iz4n";
        boolean output = validWordAbbreviation(input, abbr);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    用两个指针i,j分别从头开始匹配，j遇到数字，就先把数字x解析出来，然后i移动x位，
    继续匹配。如果不能匹配就返回false。
    */
	
	/*
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: valid word abbreviation
     */
	public static boolean validWordAbbreviation(String word, String abbr) {
		int i = 0, j = 0;
		
		while(i < word.length() && j < abbr.length()) {
			if(word.charAt(i) == abbr.charAt(j)) {
				i++;
				j++;
			} else if((abbr.charAt(j) > '0') && (abbr.charAt(j) <= '9')) {
				int start = j;
				while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
					j++;
				}
				i += Integer.valueOf(abbr.substring(start, j));
			} else {
				return false;
			}
		}
		
		return (i == word.length()) && (j == abbr.length());
	}

}
