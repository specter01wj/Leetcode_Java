package com.buddyStrings;
import java.util.*;

/*Given two strings a and b, return true if you can swap two 
letters in a so the result is equal to b, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) 
such that i != j and swapping the characters at a[i] and b[j]. 
For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

 

Example 1:

Input: a = "ab", b = "ba"
Output: true
Explanation: You can swap a[0] = 'a' and a[1] = 'b' to get "ba", 
which is equal to b.

Example 2:

Input: a = "ab", b = "ab"
Output: false
Explanation: The only letters you can swap are a[0] = 'a' and 
a[1] = 'b', which results in "ba" != b.

Example 3:

Input: a = "aa", b = "aa"
Output: true
Explanation: You can swap a[0] = 'a' and a[1] = 'a' to get "aa", 
which is equal to b.

Example 4:

Input: a = "aaaaaaabc", b = "aaaaaaacb"
Output: true*/

public class E859_Buddy_Strings {

	public static void main(String[] args) {
		String input1 = "aba";
		String input2 = "baa";
        boolean output = buddyStrings(input1, input2);
        System.out.println("input1: " + (input1) + " input2: " + (input2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    如果两个字符串长度不相等，返回False。如果长度相等，并且字符串也完全相同，
    那么就找是否有相同的字符。如果字符串不相同，那么就看是否刚好有两个位置的字符不同，
    并且这两个位置的字符满足A[i]==B[j] && A[j]==B[i].
    If A.length() != B.length(): no possible swap
	If A == B, we need swap two same characters. Check is duplicated char in A.
	In other cases, we find index for A[i] != B[i]. 
	There should be only 2 diffs and it's our one swap.
    */
	
	/**
     * @param a: string A
     * @param b: string B
     * @return: boolean
     */
	public static boolean buddyStrings(String a, String b) {
		if(a.length() != b.length()) return false;
		
		if(a.contentEquals(b)) {
			Set<Character> s = new HashSet<Character>();
			for(char c : a.toCharArray()) {
				s.add(c);
			}
			return s.size() < a.length();
		}
		
		List<Integer> dif = new ArrayList<>();
		
		for(int i = 0; i < a.length(); ++i) {
			if(a.charAt(i) != b.charAt(i)) {
				dif.add(i);
			}
		}
		
		return dif.size() == 2 && a.charAt(dif.get(0)) == b.charAt(dif.get(1))
				&& a.charAt(dif.get(1)) == b.charAt(dif.get(0));
	}

}
