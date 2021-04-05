package com.reorderDatainLogFiles;
import java.util.*;

/*You are given an array of logs. Each log is a space-delimited 
string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase 
			English letters.
Digit-logs: All words (except the identifier) consist of digits.

Reorder these logs so that:

1. The letter-logs come before all digit-logs.
2. The letter-logs are sorted lexicographically by their contents. 
   If their contents are the same, then sort them lexicographically 
   by their identifiers.
3. The digit-logs maintain their relative ordering.

Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig",
				"let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1",
		"dig2 3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", 
"art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".

Example 2:

Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]*/

public class E937_Reorder_Data_in_Log_Files {

	public static void main(String[] args) {
		String[] input = {"dig1 8 1 5 1","let1 art can","dig2 3 6",
				"let2 own kit dig","let3 art zero"};
		System.out.println("input: " + Arrays.toString(input));
        String[] output = reorderLogFiles(input);
        System.out.println("output: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. guaranteed to have a word following an identifier (allows me to 
    	use indexOf ' ' freely).
	2. letter logs need to be ordered lexicographically, so we can use 
		built in compare function when we know we have two.
	3. number logs need to be sorted naturally, so we just say they're 
		all "equal" to eachother and trust java's built in sort feature 
		to be stable.
	4. number logs need to be after letter logs, so once we find out 
		they're different, we return one of the other and short-circuit.
    */
	
	/*
     * @param logs: a list of strings
     * @return: sort logs
     */
	public static String[] reorderLogFiles(String[] logs) {
		Comparator<String> myComp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                char s1FirstChar = s1.charAt(s1SpaceIndex+1);
                char s2FirstChar = s2.charAt(s2SpaceIndex+1);
                
                if (s1FirstChar <= '9') {
                    if (s2FirstChar <= '9') return 0;
                    else return 1;
                }
                if (s2FirstChar <= '9') return -1;
                
                int preCompute = s1.substring(s1SpaceIndex + 1).compareTo(s2.substring(s2SpaceIndex + 1));
                if (preCompute == 0) return s1.substring(0, s1SpaceIndex).compareTo(s2.substring(0, s2SpaceIndex));
                
                return preCompute;
			}
		};
		
		Arrays.sort(logs, myComp);
		
        return logs;
	}

}
