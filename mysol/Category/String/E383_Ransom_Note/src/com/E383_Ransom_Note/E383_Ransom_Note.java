package com.E383_Ransom_Note;

import java.util.*;

/*Given an arbitrary ransom note string and another string containing letters 
 * from all the magazines, write a function that will return true if the 
 * ransom note can be constructed from the magazines ; otherwise, 
 * it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

public class E383_Ransom_Note {

	public static void main(String[] args) {
		int[] input = {7,1,5,3,6,4};//{7,6,4,3,1};
        int output = maxProfit(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    开一个arr数组，遍历magazine的内容记录每个字符出现的个数，
    然后继续遍历ransomNote的内容减去相应字符的个数，
    若出现某个字符的个数小于0，则返回False
    */
	
	/*
     * @param ransomNote: a string
     * @param magazine: a string
     * @return boolean: whether the ransom note can be constructed from the magazines
     */
	

}
