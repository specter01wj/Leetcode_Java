package com.shortestCompletingWord;
import java.util.*;

/*
Given a string licensePlate and an array of strings words, 
find the shortest completing word in words.

A completing word is a word that contains all the letters in 
licensePlate. Ignore numbers and spaces in licensePlate, and 
treat letters as case insensitive. If a letter appears more 
than once in licensePlate, then it must appear in the word 
the same number of times or more.

For example, if licensePlate = "aBc 12c", then it contains 
letters 'a', 'b' (ignoring case), and 'c' twice. 
Possible completing words are "abccdef", "caaacab", and "cbca".

Return the shortest completing word in words. It is guaranteed 
an answer exists. If there are multiple shortest completing words, 
return the first one that occurs in words.


Example 1:

Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
Output: "steps"
Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
"step" contains 't' and 'p', but only contains 1 's'.
"steps" contains 't', 'p', and both 's' characters.
"stripe" is missing an 's'.
"stepple" is missing an 's'.
Since "steps" is the only word containing all the letters, that is the answer.

Example 2:

Input: licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
Output: "pest"
Explanation: licensePlate only contains the letter 's'. 
All the words contain 's', but among these "pest", "stew", and "show" are shortest. 
The answer is "pest" because it is the word that appears earliest of the 3.
*/

public class E748_Shortest_Completing_Word {

	public static void main(String[] args) {
		String input = "1s3 PSt";
		String[] word = {"step","steps","stripe","stepple"};
        String output = shortestCompletingWord(input, word);
        System.out.println("input: " + input + "; word: " + Arrays.toString(word) + "\noutput: " + (output));
	}
	
	public static String shortestCompletingWord(String licensePlate, String[] words) {
		int[] target = toArray(licensePlate);
        String res = null;
        for(String next : words){
            boolean good = true;
            int[] nextArray = toArray(next);
            for(int i = 0; i < 26 && good; i++){
                if(target[i] > nextArray[i]) good = false;
            }
            if(good && (res == null || res.length() > next.length())){
                res = next;
            }
        }
        return res;
	}
	
	static int[] toArray(String s){
        int[] res = new int[26];
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(Character.isLetter(c)){
                if(c >= 'a' && c <= 'z') {
                    res[c - 'a']++;
                } else {
                    res[c - 'A']++;
                }
            }
        }
        return res;
    }

}
