package com.shortestDistancetoaCharacter;
import java.util.*;

/*
Given a string s and a character c that occurs in s, 
return an array of integers answer where answer.length == s.length 
and answer[i] is the distance from index i to the closest 
occurrence of character c in s.

The distance between two indices i and j is abs(i - j), 
where abs is the absolute value function.


Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, 
but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.

Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]
*/

public class E821_Shortest_Distance_to_a_Character {

	public static void main(String[] args) {
		String input = "loveleetcode";
        int[] output = shortestToChar(input, 'e');
        System.out.println("input: " + (input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    将字符串按正、逆顺序两次扫描，第一次扫描计算当前位置字母与前一个目标字母之间的距离，
    后一次扫描计算当前位置字母与后一个字母之间的距离，两者取小即可。
    */
	
	/**
     * @param S: 
     * @param C: 
     * @return: nothing
     */
	public static int[] shortestToChar(String s, char c) {
		int n = s.length();
        int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == c) pos = i;
            res[i] = i - pos;
        }
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == c)  pos = i;
            res[i] = Math.min(res[i], Math.abs(i - pos));
        }
        
        return res;
	}

}
