package com.countingWordsWithaGivenPrefix;
import java.util.*;

/*
You are given an array of strings words and a string pref.

Return the number of strings in words that contain pref as a prefix.

A prefix of a string s is any leading contiguous substring of s.


Example 1:

Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".

Example 2:

Input: words = ["leetcode","win","loops","success"], pref = "code"
Output: 0
Explanation: There are no strings that contain "code" as a prefix.
*/

public class E2185_Counting_Words_With_a_Given_Prefix {

	public static void main(String[] args) {
		String[] input = {"pay","attention","practice","attend"};
		String pref = "at";
		int output = prefixCount(input, pref);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int prefixCount(String[] words, String pref) {
        int ans = 0;
        for(String w: words) {
            ans += (w.indexOf(pref) == 0) ? 1 : 0;
        }
        return ans;
    }

}
