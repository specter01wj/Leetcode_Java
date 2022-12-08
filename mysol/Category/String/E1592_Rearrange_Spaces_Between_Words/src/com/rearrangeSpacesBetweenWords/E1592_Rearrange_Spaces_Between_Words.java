package com.rearrangeSpacesBetweenWords;
import java.util.*;

public class E1592_Rearrange_Spaces_Between_Words {

	public static void main(String[] args) {
		String input = "  this   is  a sentence ";
        String output = reorderSpaces(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    metacharacter
    */
	
	/**
     * @param text: a string
     * @return: the string after rearranging the spaces
     */
	public static String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int cnt = words.length;
        int spaces = (int)text.chars().filter(c -> c == ' ').count();
        int gap = cnt <= 1 ? 0 : spaces / (cnt - 1); 
        int trailingSpaces = spaces - gap * (cnt - 1);
        return String.join(" ".repeat(gap), words) + " ".repeat(trailingSpaces); 
    }

}
