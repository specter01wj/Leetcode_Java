package com.keyboardRow;
import java.util.*;

/*Given an array of strings words, return the words that can be typed 
 using letters of the alphabet on only one row of American keyboard 
 like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".


Example 1:

Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
Example 2:

Input: words = ["omk"]
Output: []
Example 3:

Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]*/

public class E500_Keyboard_Row {

	public static void main(String[] args) {
		String[] input = {"Hello","Alaska","Dad","Peace"};
        String[] output = findWords(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
	 * solution:
	将键盘每一行的字母分别存入三个集合中，每次根据单词首字母决定在哪个集合，再判断后面的字母是否在此集合中。
	*/
	
	/**
     * @param words: a list of strings
     * @return: return a list of strings
     */
	public static String[] findWords(String[] words) {
		List<String> list = new ArrayList<>();
		
		for(String word : words) {
			if(valid(word)) {
				list.add(word);
			}
		}
		
		String[] ans = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		
		return ans;
	}
	
	public static boolean valid(String word) {
		Set<Character> set1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> set2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> set3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        
        boolean[] flag = new boolean[3];
        Arrays.fill(flag, true);
        for(char c : word.toLowerCase().toCharArray()) {
        	if(!set1.contains(c)) {
        		flag[0] = false;
        	}
        	if(!set2.contains(c)) {
        		flag[1] = false;
        	}
        	if(!set3.contains(c)) {
        		flag[2] = false;
        	}
        }
        
        return flag[0] || flag[1] || flag[2];
	}

}
