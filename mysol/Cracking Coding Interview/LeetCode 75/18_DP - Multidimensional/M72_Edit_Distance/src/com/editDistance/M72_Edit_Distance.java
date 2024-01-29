package com.editDistance;
import java.util.*;

/*
Given two strings word1 and word2, return the minimum number of 
operations required to convert word1 to word2.

You have the following three operations permitted on a word:

 .Insert a character
 .Delete a character
 .Replace a character
*/

public class M72_Edit_Distance {

	public static void main(String[] args) {
		String word1 = "horse", word2 = "ros";
		int output = minDistance(word1, word2);
        System.out.println("input: " + (word1) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Dynamic Programming
    */
	
	/*
     * @param word1: a string
     * @param word1: a string
     * @return: the minimum number of operations required to convert word1 to word2
     */
	public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first row and column
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Compute the distances
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No operation needed
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                                    Math.min(dp[i - 1][j],   // Delete
                                            dp[i][j - 1])); // Insert
                }
            }
        }

        return dp[m][n];
    }

}
