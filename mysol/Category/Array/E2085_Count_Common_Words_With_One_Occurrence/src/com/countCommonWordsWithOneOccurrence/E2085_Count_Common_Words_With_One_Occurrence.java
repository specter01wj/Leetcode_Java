package com.countCommonWordsWithOneOccurrence;
import java.util.*;

/*
Given two string arrays words1 and words2, return the number of strings 
that appear exactly once in each of the two arrays.


Example 1:

Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
Output: 2
Explanation:
- "leetcode" appears exactly once in each of the two arrays. We count this string.
- "amazing" appears exactly once in each of the two arrays. We count this string.
- "is" appears in each of the two arrays, but there are 2 occurrences of it in words1. We do not count this string.
- "as" appears once in words1, but does not appear in words2. We do not count this string.
Thus, there are 2 strings that appear exactly once in each of the two arrays.

Example 2:

Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
Output: 0
Explanation: There are no strings that appear in each of the two arrays.

Example 3:

Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
Output: 1
Explanation: The only string that appears exactly once in each of the two arrays is "ab".
*/

public class E2085_Count_Common_Words_With_One_Occurrence {

	public static void main(String[] args) {
		String[] input = {"leetcode","is","amazing","as","is"}, words2 = {"amazing","leetcode","is"};
		int output = countWords(input, words2);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
		
        for (String word : words1) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
			
        int count = 0;
        for (String word : words1) {
            if (map1.get(word) == 1 && map2.getOrDefault(word, 0) == 1) {
                count++;
            }
        }
        return count;
    }

}
