package com.latestTimebyReplacingHiddenDigits;
import java.util.*;

/*
You are given a string time in the form of  hh:mm, where some of 
the digits in the string are hidden (represented by ?).

The valid times are those inclusively between 00:00 and 23:59.

Return the latest valid time you can get from time by replacing the hidden digits.


Example 1:

Input: time = "2?:?0"
Output: "23:50"
Explanation: The latest hour beginning with the digit '2' is 23 and 
the latest minute ending with the digit '0' is 50.

Example 2:

Input: time = "0?:3?"
Output: "09:39"

Example 3:

Input: time = "1?:22"
Output: "19:22"
*/

public class E1736_Latest_Time_by_Replacing_Hidden_Digits {

	public static void main(String[] args) {
		String input = "2?:?0";
        String output = maximumTime(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Convert to char array list then process
    */
	
	/**
     * @param time: a string
     * @return: the latest valid time you can get from time by replacing the hidden digits
     */
	public static String maximumTime(String time) {
        char[] a = time.toCharArray();
        for (int i = 0; i < 5; ++i) {
            if (a[i] == '?') {
                if (i == 0) {
                    a[i] = a[1] <= '3' || a[1] == '?' ? '2' : '1';
                } else if (i == 1) {
                    a[i] = a[0] == '2' ? '3' : '9';
                } else if (i == 3) {
                    a[i] = '5';
                } else if (i == 4) {
                    a[i] = '9';
                }
            }
        }
        return String.valueOf(a);
    }

}
