package com.sentenceSimilarity;
import java.util.*;

/*
We can represent a sentence as an array of words, for example, 
the sentence "I am happy with leetcode" can be represented as 
arr = ["I","am",happy","with","leetcode"].

Given two sentences sentence1 and sentence2 each represented as 
a string array and given an array of string pairs similarPairs 
where similarPairs[i] = [xi, yi] indicates that the two words 
xi and yi are similar.

Return true if sentence1 and sentence2 are similar, or false if 
they are not similar.

Two sentences are similar if:

, They have the same length (i.e., the same number of words)
. sentence1[i] and sentence2[i] are similar.

Notice that a word is always similar to itself, also notice that 
the similarity relation is not transitive. For example, 
if the words a and b are similar, and the words b and c are similar, 
a and c are not necessarily similar.
*/

public class E734_Sentence_Similarity {

	public static void main(String[] args) {
		E734_Sentence_Similarity sol = new E734_Sentence_Similarity();
        
        String[] sentence1 = {"great", "acting", "skills"};
        String[] sentence2 = {"fine", "drama", "talent"};
        List<List<String>> similarPairs = Arrays.asList(
            Arrays.asList("great", "fine"),
            Arrays.asList("drama", "acting"),
            Arrays.asList("skills", "talent")
        );
        boolean output = sol.areSentencesSimilar(sentence1, sentence2, similarPairs);
        System.out.println("input: " + Arrays.toString(sentence1) + " and " + Arrays.toString(sentence2) + "\noutput: " + (output));
	}
	
	
	public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        // Check if the sentences have the same length
        if (sentence1.length != sentence2.length) {
            return false;
        }
        
        // Create a map to store similar pairs
        Map<String, Set<String>> similarMap = new HashMap<>();
        
        // Populate the map with the similar pairs
        for (List<String> pair : similarPairs) {
            similarMap.computeIfAbsent(pair.get(0), k -> new HashSet<>()).add(pair.get(1));
            similarMap.computeIfAbsent(pair.get(1), k -> new HashSet<>()).add(pair.get(0));
        }
        
        // Check each word pair in the sentences
        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            
            // A word is always similar to itself
            if (word1.equals(word2)) {
                continue;
            }
            
            // Check if the words are similar according to the map
            if (!similarMap.getOrDefault(word1, new HashSet<>()).contains(word2) && 
                !similarMap.getOrDefault(word2, new HashSet<>()).contains(word1)) {
                return false;
            }
        }
        
        // All words are similar
        return true;
    }

}
