package com.shortestWordDistance;
import java.util.*;

/*Given a list of words and two words word1 and word2, 
 return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1*/

public class E243_Shortest_Word_Distance {

	public static void main(String[] args) {
		String[] input = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding", word2 = "practice";
        int output = shortestDistance(input, word1, word2);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    遍历一遍words list，找到word1就更新pointer1，找到word2就更新pointer2。 
    每找到任何一个word，就计算出当前distance，跟min打擂台。
	
	时间复杂度：O(n) 空间复杂度：O(1)
    */
	
	/**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
	public static int shortestDistance(String[] words, String word1, String word2) {
		int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
		
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				p1 = i;
			}
			if(words[i].equals(word2)) {
				p2 = i;
			}
			if(p1 != -1 && p2 != -1) {
				min = Math.min(min, Math.abs(p1 - p2));
			}
		}
		
		return min;
	}

}
