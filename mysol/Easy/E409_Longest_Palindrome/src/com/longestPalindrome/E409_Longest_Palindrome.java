package com.longestPalindrome;
import java.util.*;

/*
Given a string s which consists of lowercase or uppercase letters, 
return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.


Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", 
whose length is 7.

Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", 
whose length is 1.
*/

public class E409_Longest_Palindrome {

	public static void main(String[] args) {
		String input = "abccccdd";
        int output = longestPalindrome(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    hash set 方法，加char到hashset的时候就统计结果，最后如果set里有剩余，
    说明有奇数出现的字符，字符长度减去奇数个数就是答案
    */
	
	/**
     * @param nums: a string
     * @return: the length of the longest palindromes that can be built
     */
	public static int longestPalindrome(String s) {
		Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        int remove = set.size();
        if (remove > 0) {
            remove -= 1;
        }
        
        return s.length() - remove;
	}

}
