package com.strCompression;

import java.util.*;



public class E443_String_Compression {

	public static void main(String[] args) {
		char[] input = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};//{'a','a','b','b','b','c','c','c'};
        int output = compress(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
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
