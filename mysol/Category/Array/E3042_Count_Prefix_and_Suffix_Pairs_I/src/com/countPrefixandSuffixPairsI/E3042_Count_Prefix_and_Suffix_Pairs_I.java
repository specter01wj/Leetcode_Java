package com.countPrefixandSuffixPairsI;
import java.util.*;

/*
You are given a 0-indexed string array words.

Let's define a boolean function isPrefixAndSuffix that takes two strings, 
str1 and str2:

	. isPrefixAndSuffix(str1, str2) returns true if str1 is both a prefix 
		and a suffix of str2, and false otherwise.
	
For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a 
prefix of "ababa" and also a suffix, but isPrefixAndSuffix("abc", "abcd") is false.

Return an integer denoting the number of index pairs (i, j) such that i < j, 
and isPrefixAndSuffix(words[i], words[j]) is true.
*/

public class E3042_Count_Prefix_and_Suffix_Pairs_I {

	public static void main(String[] args) {
		E3042_Count_Prefix_and_Suffix_Pairs_I solution = new E3042_Count_Prefix_and_Suffix_Pairs_I();
		String[] input = {"a","aba","ababa","aa"};
		int output = solution.countPrefixSuffixPairs(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        // Check if str1 is a prefix and a suffix of str2
        return str2.startsWith(str1) && str2.endsWith(str1);
    }

}
