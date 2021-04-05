package com.longPressedName;
import java.util.*;

/*Your friend is typing his name into a keyboard. Sometimes, 
when typing a character c, the key might get long pressed, 
and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. 
Return True if it is possible that it was your friends name, 
with some characters (possibly none) being long pressed.

 

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true

Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.
*/

public class E925_Long_Pressed_Name {

	public static void main(String[] args) {
		String input = "leelee";
		String typed = "lleeelee";
        boolean output = isLongPressedName(input, typed);
        System.out.println("input: " + (input) + " typed: " + (typed) + "\noutput: " + (output));
	}
	
	/*
    solution:
    采用双指针的做法来解决本题，假设name的指针为 i,typed的指针为 j,两者均从 0 开始。 
    使结果为false的情况主要有四种： 
    1. typed的第一个字符与name的第一个字符不相等 
    2. namei != typedj 成立，且typedj != typedj-1成立，
       比如：name = "ab", i = 1, typed = "ac", j = 1 
    3. name遍历完成，typed还没有遍历完成且出现了与name最后一个字符不一样的字符，
       比如：name = "ab", typed = "abbbbc" 4. typed遍历完成，而name还没有遍历完成
    */
	
	/**
     * @param name: your friend's name
     * @param typed: the typed string
     * @return: Return True if it is possible that it was your friends name
     */
	public static boolean isLongPressedName(String name, String typed) {
		int m = name.length(), n = typed.length();
		int i = 0;
		
		for(int j = 0; j < n; ++j) {
			if(i < m && name.charAt(i) == typed.charAt(j)) {
				++i;
			} else if(j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
				return false;
			}
		}
		
		return i == m;
	}

}
