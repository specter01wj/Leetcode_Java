package com.E344_Reverse_String;

import java.util.*;



public class E344_Reverse_String {

	public static void main(String[] args) {
		char[] input = {'h','e','l','l','o'};
        char[] output = reverseString(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	public static char[] reverseString(char[] s) {
        char[] str = new char[s.length];
        
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        str = s;
        
        return str;
    }

}
