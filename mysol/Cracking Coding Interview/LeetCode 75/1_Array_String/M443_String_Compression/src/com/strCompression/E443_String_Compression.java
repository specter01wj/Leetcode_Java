package com.strCompression;

import java.util.*;

/*Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.

 
Follow up:
Could you solve it using only O(1) extra space?

 
Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 

Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
 

Example 3:

Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
 

Note:

All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.
Accepted*/

public class E443_String_Compression {

	public static void main(String[] args) {
		char[] input = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};//{'a','a','b','b','b','c','c','c'};
        int output = compress(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    while 直到 index 和 index + 1 不相等。 这时候把字符加到StringBuffer里。
    新chars的index设成0开始，如果count不等于1就加到chars第二位, 一直重复到index扫完所有字符。 
    最后一个新chars所加的位置的值就是compress的个数。
    */
	
	/**
     * @param str a string
     * @return a compressed string
     */
	public static int compress(char[] chars) {
		int indexAns = 0, index = 0;
		while(index < chars.length) {
			char currentChar = chars[index];
			int count = 0;
			while(index < chars.length && chars[index] == currentChar) {
				index++;
				count++;
			}
			chars[indexAns++] = currentChar;
//			char[] v1 = (Integer.toString(count).toCharArray());
			if(count != 1) {
				for(char c : Integer.toString(count).toCharArray()) {
					chars[indexAns++] = c;
				}
			}
		}
		
		return indexAns;
	}

}
