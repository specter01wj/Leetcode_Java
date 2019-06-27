import java.util.*;

/*Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle 
is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
*/

public class E28_Implement_strStr {

	public static void main(String[] args) {
		String input = "hello";
		String needle = "ll";
        int output = strStr(input, needle);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    The points of interest are the peaks and valleys in the given graph. 
    We need to find the largest peak following the smallest valley. 
    We can maintain two variables - minprice and maxprofit corresponding 
    to the smallest valley and maximum profit (maximum difference between 
    selling price and minprice) obtained so far respectively.
    */
	
	/*
     * @param haystack: source string to be scanned.
     * @param needle: target string containing the sequence of characters to match.
     * @return: a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     */
	public static int strStr(String haystack, String needle) {
		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            // finished loop, needle found
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
	}

}
