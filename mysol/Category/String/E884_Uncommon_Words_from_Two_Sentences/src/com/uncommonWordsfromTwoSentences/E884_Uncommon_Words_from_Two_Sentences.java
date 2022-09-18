package com.uncommonWordsfromTwoSentences;
import java.util.*;

/*
A sentence is a string of single-space separated words where each word 
consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, 
and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. 
You may return the answer in any order.


Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]

Example 2:

Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]
*/

public class E884_Uncommon_Words_from_Two_Sentences {

	public static void main(String[] args) {
		String input1 = "this apple is sweet";
		String input2 = "this apple is sour";
        String[] output = uncommonFromSentences(input1, input2);
        System.out.println("input1: " + (input1) + "; input2: " + input2 + "\noutput: " + Arrays.toString(output));
	}
	
	
	public static String[] uncommonFromSentences(String s1, String s2) {
		Map<String, Integer> count = new HashMap();
        for (String word: s1.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (String word: s2.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        List<String> ans = new LinkedList();
        for (String word: count.keySet()) {
            if (count.get(word) == 1) {
                ans.add(word);
            }
        }

        return ans.toArray(new String[ans.size()]);
	}

}
