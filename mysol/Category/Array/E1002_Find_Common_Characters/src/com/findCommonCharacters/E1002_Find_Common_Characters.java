package com.findCommonCharacters;
import java.util.*;

/*Given an array A of strings made only from lowercase letters, 
return a list of all characters that show up in all strings 
within the list (including duplicates).  
For example, if a character occurs 3 times in all strings 
but not 4 times, you need to include that character three 
times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]*/

public class E1002_Find_Common_Characters {

	public static void main(String[] args) {
		String[] input = {"bella","label","roller"};
		List<String> output = commonChars(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    using 2 arrays
    */
	
	/*
     * @param prices: a list of strings
     * @return: find common characters
     */
	public static List<String> commonChars(String[] A) {
		int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char ch : A[0].toCharArray()) {
        	count1[ch - 'a']++;
        }

        for (int i = 1; i < A.length - 1; i++) {
          for (char c : A[i].toCharArray()) {
            if (count1[c - 'a'] > 0) {
              count2[c - 'a']++;
              count1[c - 'a']--;
            }
          }
          count1 = count2;
          count2 = new int[26];
        }

        List<String> result = new ArrayList<>();

        for (char c : A[A.length - 1].toCharArray()) {
          if (count1[c - 'a'] > 0) {
            result.add(String.valueOf(c));
            count1[c - 'a']--;
          }
        }
        return result;
	}

}
