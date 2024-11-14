package com.splitStringsbySeparator;
import java.util.*;
import java.util.regex.Pattern;

/*
Given an array of strings words and a character separator, 
split each string in words by separator.

Return an array of strings containing the new strings formed 
after the splits, excluding empty strings.
*/

public class E2788_Split_Strings_by_Separator {

	public static void main(String[] args) {
		E2788_Split_Strings_by_Separator solution = new E2788_Split_Strings_by_Separator();
		List<String> input = List.of("one.two.three", "four.five", "six");
		char separator = '.';
		List<String> output = solution.splitWordsBySeparator(input, separator);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        String separatorStr = Pattern.quote(String.valueOf(separator)); // Escapes special characters

        for (String word : words) {
            // Split the word by the separator
            String[] parts = word.split(separatorStr);
            
            // Add non-empty strings to the result
            for (String part : parts) {
                if (!part.isEmpty()) {
                    result.add(part);
                }
            }
        }

        return result;
    }

}
