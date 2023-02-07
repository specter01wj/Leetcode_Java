package com.maximumNumberofWordsYouCanType;
import java.util.*;

/*
There is a malfunctioning keyboard where some letter keys do not work. 
All other keys on the keyboard work properly.

Given a string text of words separated by a single space (no leading or trailing 
spaces) and a string brokenLetters of all distinct letter keys that are broken, 
return the number of words in text you can fully type using this keyboard.


Example 1:

Input: text = "hello world", brokenLetters = "ad"
Output: 1
Explanation: We cannot type "world" because the 'd' key is broken.

Example 2:

Input: text = "leet code", brokenLetters = "lt"
Output: 1
Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.

Example 3:

Input: text = "leet code", brokenLetters = "e"
Output: 0
Explanation: We cannot type either word because the 'e' key is broken.
*/

public class E1935_Maximum_Number_of_Words_You_Can_Type {

	public static void main(String[] args) {
		String input = "hello world";
		String brokenLetters = "ad";
        int output = canBeTypedWords(input, brokenLetters);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashSet
    */
	
	/**
     * @param text: a string
     * @param brokenLetters: a string
     * @return: the number of words in text you can fully type using this keyboard
     */
	public static int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> no = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            no.add(c);
        }
        int cnt = 0;
        outer:
        for (String word : text.split("\\s")) {
            for (char c : word.toCharArray()) {
                if (no.contains(c)) {
                    continue outer;
                }
            }
            ++cnt;
        }
        return cnt;
    }

}
