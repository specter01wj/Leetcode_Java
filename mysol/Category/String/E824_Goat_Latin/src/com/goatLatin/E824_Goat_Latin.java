package com.goatLatin;
import java.util.*;

/*A sentence S is given, composed of words separated by spaces. 
Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" 
(a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" 
to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), 
remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index 
in the sentence, starting with 1.
For example, the first word gets "a" added to the end, 
the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion 
from S to Goat Latin. 


Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa 
overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"*/

public class E824_Goat_Latin {

	public static void main(String[] args) {
		String input = "I speak Goat Latin";
        String output = toGoatLatin(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    根据题目规则拼接出一个新的字符串
    1. Build a vowel set.(optional)
	2. Split 'S' to words.
	3. For each word, check if it starts with a vowel. (O(1) complexity with set).
	4. If it does, keep going. If it does not, rotate the first letter to the end.
	5. Add it to result string.
    */
	
	/**
     * @param S: 
     * @return: nothing
     */
	public static String toGoatLatin(String S) {
		Set<Character> vowel = new HashSet<Character>();
		for(char c : "aeiouAEIOU".toCharArray()) {
			vowel.add(c);
		}
		String res = "";
		int i = 0, j = 0;
		
		for(String w : S.split("\\s")) {
			res += ' ' + (vowel.contains(w.charAt(0)) ? 
					w : w.substring(1) + w.charAt(0)) + "ma";
			for(j = 0, ++i; j < i; ++j) {
				res += "a";
			}
		}
		
		return res.substring(1);
	}

}
