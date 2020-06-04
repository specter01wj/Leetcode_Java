package com.E38_Count_and_Say;

import java.util.*;

/*The count-and-say sequence is the sequence of integers with the first five terms 
 * as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"*/

public class E38_Count_and_Say {

	public static void main(String[] args) {
		int input = 4;
        String output = countAndSay(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    
    */
	
	/*
     * @param n: an integer
     * @return: string, the nth term of the count-and-say sequence
     */
	public static String countAndSay(int n) {
		String oldString = "1";
		
		while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char [] oldChars = oldString.toCharArray();

            for (int i = 0; i < oldChars.length; i++) {
                int count = 1;
                while ((i+1) < oldChars.length && oldChars[i] == oldChars[i+1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
            }
            oldString = sb.toString();
        }
		
		return oldString;
	}

}
