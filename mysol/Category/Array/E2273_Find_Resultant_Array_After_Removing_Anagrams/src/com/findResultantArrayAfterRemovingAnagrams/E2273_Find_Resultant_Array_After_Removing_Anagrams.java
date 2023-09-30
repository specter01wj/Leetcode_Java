package com.findResultantArrayAfterRemovingAnagrams;
import java.util.*;

/*
You are given a 0-indexed string array words, where words[i] consists of lowercase 
English letters.

In one operation, select any index i such that 0 < i < words.length and words[i - 1] 
and words[i] are anagrams, and delete words[i] from words. Keep performing this operation 
as long as you can select an index that satisfies the conditions.

Return words after performing all operations. It can be shown that selecting the indices 
for each operation in any arbitrary order will lead to the same result.

An Anagram is a word or phrase formed by rearranging the letters of a different word or 
phrase using all the original letters exactly once. For example, "dacb" is an anagram 
of "abdc".


Example 1:

Input: words = ["abba","baba","bbaa","cd","cd"]
Output: ["abba","cd"]
Explanation:
One of the ways we can obtain the resultant array is by using the following operations:
- Since words[2] = "bbaa" and words[1] = "baba" are anagrams, we choose index 2 and delete words[2].
  Now words = ["abba","baba","cd","cd"].
- Since words[1] = "baba" and words[0] = "abba" are anagrams, we choose index 1 and delete words[1].
  Now words = ["abba","cd","cd"].
- Since words[2] = "cd" and words[1] = "cd" are anagrams, we choose index 2 and delete words[2].
  Now words = ["abba","cd"].
We can no longer perform any operations, so ["abba","cd"] is the final answer.


Example 2:

Input: words = ["a","b","c","d","e"]
Output: ["a","b","c","d","e"]
Explanation:
No two adjacent strings in words are anagrams of each other, so no operations are performed.
*/

public class E2273_Find_Resultant_Array_After_Removing_Anagrams {

	public static void main(String[] args) {
		String[] input = {"abba","baba","bbaa","cd","cd"};
		List<String> output = removeAnagrams(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Iterate through the words array, and for each word, check if it's an anagram of the 
    previous word. If it is, you remove it from the list. 
    Note that since removing an element will alter the structure of the list, 
    we need to adjust our loop counter accordingly.
	To check if two words are anagrams, you can sort their characters and see if they match.
    */
	
	/*
     * @param words: a list of strings
     * @return: words after performing all operations
     */
	public static List<String> removeAnagrams(String[] words) {
        List<String> resultList = new ArrayList<>(Arrays.asList(words));
        
        int i = 1; // start from the second word
        while (i < resultList.size()) {
            if (areAnagrams(resultList.get(i), resultList.get(i - 1))) {
                // remove word at position i
                resultList.remove(i);
            } else {
                i++;
            }
        }
        return resultList;
    }

    private static boolean areAnagrams(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

}
