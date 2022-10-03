package com.occurrencesAfterBigram;
import java.util.*;

/*
Given two strings first and second, consider occurrences in 
some text of the form "first second third", where second comes 
immediately after first, and third comes immediately after second.

Return an array of all the words third for each occurrence 
of "first second third".


Example 1:

Input: text = "alice is a good girl she is a good student", 
		first = "a", second = "good"
Output: ["girl","student"]
Example 2:

Input: text = "we will we will rock you", 
		first = "we", second = "will"
Output: ["we","rock"]
*/

public class E1078_Occurrences_After_Bigram {

	public static void main(String[] args) {
		String text = "alice is a good girl she is a good student";
		String input1 = "a", input2 = "good";
        String output[] = findOcurrences(text, input1, input2);
        System.out.println("Text: " + text + " Input1: " + (input1) + 
        		" Input2: " + (input2) + "\noutput: " + Arrays.toString(output)); 
	}
	
	
	public static String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 2; i < words.length; ++i) {
            if (first.equals(words[i - 2]) && second.equals(words[i - 1])) {
                ans.add(words[i]);
            }
        }
        return ans.toArray(new String[0]);
    }

}
