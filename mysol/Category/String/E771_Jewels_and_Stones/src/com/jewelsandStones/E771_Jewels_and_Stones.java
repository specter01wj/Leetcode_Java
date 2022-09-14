package com.jewelsandStones;
import java.util.*;

/*
You're given strings jewels representing the types of stones that are jewels, 
and stones representing the stones you have. 
Each character in stones is a type of stone you have. You want to know 
how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone 
from "A".


Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
*/

public class E771_Jewels_and_Stones {

	public static void main(String[] args) {
		String input1 = "aA";
		String input2 = "aAAbbbb";
        int output = numJewelsInStones(input1, input2);
        System.out.println("input1: " + (input1) + "; input2: " + input2 + "\noutput: " + (output));
	}
	
	
	public static int numJewelsInStones(String jewels, String stones) {
		int res = 0;
        Set setJ = new HashSet();
        
        for (char j: jewels.toCharArray()) {
        	setJ.add(j);
        }
        for (char s: stones.toCharArray()) {
        	if (setJ.contains(s)) {
        		res++;
        	}
        }
        return res;
	}

}
