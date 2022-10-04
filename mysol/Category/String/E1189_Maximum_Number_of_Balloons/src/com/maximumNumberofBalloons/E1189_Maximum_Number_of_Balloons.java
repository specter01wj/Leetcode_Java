package com.maximumNumberofBalloons;
import java.util.*;

/*
Given a string text, you want to use the characters of text 
to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the 
maximum number of instances that can be formed.


Example 1:

Input: text = "nlaebolko"
Output: 1

Example 2:

Input: text = "loonbalxballpoon"
Output: 2

Example 3:

Input: text = "leetcode"
Output: 0
*/

public class E1189_Maximum_Number_of_Balloons {

	public static void main(String[] args) {
		String input = "loonbalxballpoon";
        int output = maxNumberOfBalloons(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Count chars of both text and balloon and find 
    the minimum of the times of the count of chars of text / balloon
    */
	
	/**
     * @param s: a string
     * @return: the maximum number of instances that can be formed
     */
	public static int maxNumberOfBalloons(String text) {
        int[] chars = new int[26], cntBaloon = new int[26];
        int res = 0;
        int len = text.length();
        char[] balloonStr = {'b','a','l','l','o','o','n'};
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }
        label:
        while(len > 0) {
            for (char ch : balloonStr) {
                if(chars[ch - 'a'] > 0) {
                    chars[ch - 'a']--;
                    len--;
                } else {
                    break label;
                }
            }
            res++;
        }
        
        return res;
    }

}
