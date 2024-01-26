package com.longestCommonSubsequence;
import java.util.*;

/*
Given two strings text1 and text2, return the length of their longest 
common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original 
string with some characters (can be none) deleted without changing the 
relative order of the remaining characters.

 .For example, "ace" is a subsequence of "abcde".

A common subsequence of two strings is a subsequence that is common to both strings.
*/

public class M1143_Longest_Common_Subsequence {

	public static void main(String[] args) {
		String text1 = "abcde", text2 = "ace";
        int output = longestCommonSubsequence(text1, text2);
        System.out.println("input: " + (text1) + "\noutput: " + (output));
	}
	
	
	public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Create a 2D array for dynamic programming
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Characters match, add 1 to the result of the previous characters
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Characters do not match, take the maximum of the two options
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The bottom-right corner of the dp table contains the length of the longest common subsequence
        return dp[m][n];
    }

}
