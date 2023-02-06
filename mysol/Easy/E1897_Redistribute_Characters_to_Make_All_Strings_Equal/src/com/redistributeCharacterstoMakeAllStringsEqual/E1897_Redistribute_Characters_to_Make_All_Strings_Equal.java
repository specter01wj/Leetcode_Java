package com.redistributeCharacterstoMakeAllStringsEqual;
import java.util.*;

/*
You are given an array of strings words (0-indexed).

In one operation, pick two distinct indices i and j, where words[i] is a non-empty 
string, and move any character from words[i] to any position in words[j].

Return true if you can make every string in words equal using any number of operations, 
and false otherwise.


Example 1:

Input: words = ["abc","aabc","bc"]
Output: true
Explanation: Move the first 'a' in words[1] to the front of words[2],
to make words[1] = "abc" and words[2] = "abc".
All the strings are now equal to "abc", so return true.

Example 2:

Input: words = ["ab","a"]
Output: false
Explanation: It is impossible to make all the strings equal using the operation.
*/

public class E1897_Redistribute_Characters_to_Make_All_Strings_Equal {

	public static void main(String[] args) {
		String[] input = {"abc","aabc","bc"};
		boolean output = makeEqual(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Count all chars then check if all frequencies can be divided without remaining.
    */
	
	/*
     * @param words: a list of strings
     * @return: true if you can make every string in words equal using any number of operations, 
     * and false otherwise
     */
	public static boolean makeEqual(String[] words) {
        int[] cnt = new int[26];
        for (String w : words) {
            for (int i = 0; i < w.length(); ++i) {
                ++cnt[w.charAt(i) - 'a'];
            }
        }
        for (int i = 0, n = words.length; i < 26; ++i) {
            if (cnt[i] % n != 0) {
                return false;
            }
        }
        return true;
    }

}
