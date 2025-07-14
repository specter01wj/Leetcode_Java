package com.findLengthStr;
import java.util.*;

/*
Example 2: You are given a binary string s (a string containing only "0" and "1"). 
You may choose up to one "0" and flip it to a "1". What is the length of the longest 
substring achievable that contains only "1"?

For example, given s = "1101100111", the answer is 5. 
If you perform the flip at index 2, the string becomes 1111100111.
*/

public class Ch2_findLengthStr {

	public static void main(String[] args) {
		Ch2_findLengthStr solution = new Ch2_findLengthStr();
		String input = "1101100111";
		int output = solution.findLengthStr(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public int findLengthStr(String s) {
	    // curr is the current number of zeros in the window
	    int left = 0;
	    int curr = 0;
	    int ans = 0;

	    for (int right = 0; right < s.length(); right++) {
	        if (s.charAt(right)== '0') {
	            curr++;
	        }

	        while (curr > 1) {
	            if (s.charAt(left) == '0') {
	                curr--;
	            }

	            left++;
	        }

	        ans = Math.max(ans, right - left + 1);
	    }

	    return ans;
	}

}
