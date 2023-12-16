package com.greatestCommonDivisorofStrings;
import java.util.*;

/*
For two strings s and t, we say "t divides s" if and only 
if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that 
x divides both str1 and str2.


Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
*/

public class E1071_Greatest_Common_Divisor_of_Strings {

	public static void main(String[] args) {
		String input1 = "ABABAB";
		String input2 = "ABAB";
        String output = gcdOfStrings(input1, input2);
        System.out.println("input1: " + (input1) + " Input2: " + (input2) + "\noutput: " + (output));   
	}
	
	/*
    solution:
    Euclidean algorithm
    */
	
	/**
     * @param str1: a string
     * @param str2: a string
     * @return: the largest string x such that x divides both str1 and str2
     */
	public static String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2+str1)) {
            return "";
        }
    
        int gcdVal = gcd(str1.length() , str2.length());
        return str2.substring(0, gcdVal);
    }
    
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

}
