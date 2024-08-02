package com.indexPairsofaString;
import java.util.*;

/*
Given a string text and an array of strings words, 
return an array of all index pairs [i, j] so that 
the substring text[i...j] is in words.

Return the pairs [i, j] in sorted order (i.e., sort 
them by their first coordinate, and in case of ties 
sort them by their second coordinate).
*/

public class E1065_Index_Pairs_of_a_String {

	public static void main(String[] args) {
		E1065_Index_Pairs_of_a_String solution = new E1065_Index_Pairs_of_a_String();
		String text = "thestoryofleetcodeandme";
        String[] words = {"story","fleet","leetcode"};
		int[][] output = solution.indexPairs(text, words);
        System.out.println("input: text - " + (text) + "; words - " + words + "\noutput: " + Arrays.deepToString(output));
	}
	
	/*
    solution:
    1. Loop through each character in the text: The outer loop goes through each character in the text.
	2. Check for each word: The inner loop checks each word in the words array to see if it matches the substring of text starting at the current position.
	3. Add matching pairs: If a word matches, add the starting index i and the ending index i + word.length() - 1 to the result list.
	4. Convert the list to an array and sort it: Convert the list of pairs to a 2D array and sort it first by the starting index, and then by the ending index in case of ties.
    */
	
	/*
     * @param text: a string
     * @param words: a list of strings
     * @return: the pairs [i, j] in sorted order
     */
	public int[][] indexPairs(String text, String[] words) {
        List<int[]> result = new ArrayList<>();

        // Iterate through each position in the text
        for (int i = 0; i < text.length(); i++) {
            // Check each word in the words array
            for (String word : words) {
                if (text.startsWith(word, i)) {
                    // If the word matches the substring starting from index i, add the pair
                    result.add(new int[]{i, i + word.length() - 1});
                }
            }
        }

        // Convert list to array
        int[][] pairsArray = result.toArray(new int[result.size()][]);

        // Sort the result array
        Arrays.sort(pairsArray, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        return pairsArray;
    }

}
