import java.util.*;

/*Write a function to find the longest common prefix string 
 * amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

public class E14_Longest_Common_Prefix {

	public static void main(String[] args) {
		String[] input = {"flower","flow","flight"};
        String output = longestCommonPrefix(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    // 1. Method 1, start from the first one, 
     * compare prefix with next string, until end;
    // 2. Method 2, start from the first char, 
     * compare it with all string, and then the second char
    // I am using method 1 here
    */
	
	/*
     * @param strs: a list of strings
     * @return prefix: find a prefix string
     */
	public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            while( j < strs[i].length() && j < prefix.length() 
            		&& strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if( j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }
        
        return prefix;
    }

}
