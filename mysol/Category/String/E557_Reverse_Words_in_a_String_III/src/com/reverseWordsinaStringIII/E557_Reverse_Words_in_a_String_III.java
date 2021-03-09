package com.reverseWordsinaStringIII;
import java.util.*;

/*Given a string s, reverse the order of characters in each word within 
a sentence while still preserving whitespace and initial word order.



Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:

Input: s = "God Ding"
Output: "doG gniD"*/

public class E557_Reverse_Words_in_a_String_III {

	public static void main(String[] args) {
		String input = "Let's take LeetCode contest";
        String output = reverseWords(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	public static String reverseWords(String s) {
		String[] words = s.split(" ");
		StringBuilder answer = new StringBuilder();
		
		answer.append(reverseString(words[0]));
		
		for(int i = 1; i < words.length; i++) {
			answer.append(String.valueOf(' ') + reverseString(words[i]));
		}
		
		return answer.toString();
	}
	
	public static String reverseString(String s) {
		String ans = "";
		
		for(int i = s.length() - 1; i >= 0; i--) {
			ans += String.valueOf(s.charAt(i));
		}
		
		return ans;
	}

}
