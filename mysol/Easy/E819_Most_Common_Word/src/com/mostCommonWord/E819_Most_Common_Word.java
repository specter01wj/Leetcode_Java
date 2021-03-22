package com.mostCommonWord;
import java.util.*;

/*Given a string paragraph and a string array of the banned words banned, 
return the most frequent word that is not banned. 
It is guaranteed there is at least one word that is not banned, 
and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be 
returned in lowercase.

 

Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", 
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent 
non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.

Example 2:

Input: paragraph = "a.", banned = []
Output: "a"*/

public class E819_Most_Common_Word {

	public static void main(String[] args) {
		String input = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
		String output = mostCommonWord(input, banned);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    利用哈希表记录每个单词出现的次数即可
    4 steps:
		1.remove all punctuations
		2.change to lowercase
		3.words count for each word not in banned set
		4.return the most common word
    */
	
	/**
     * @param paragraph:
     * @param banned:
     * @return: nothing
     */
	public static String mostCommonWord(String paragraph, String[] banned) {
		Set<String> ban = new HashSet<> (Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.replaceAll ("\\pP", " ").toLowerCase().split ("\\s+");
        
        for(String w : words) {
        	if(!ban.contains(w)) {
        		count.put(w, count.getOrDefault(w, 0) + 1);
        	}
        }
        
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
	}

}
