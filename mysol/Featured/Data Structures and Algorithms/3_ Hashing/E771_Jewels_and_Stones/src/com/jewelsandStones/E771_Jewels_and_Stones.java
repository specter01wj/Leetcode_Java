package com.jewelsandStones;
import java.util.*;

/*
You're given strings jewels representing the types of stones 
that are jewels, and stones representing the stones you have. 
Each character in stones is a type of stone you have. 
You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".
*/

public class E771_Jewels_and_Stones {

	public static void main(String[] args) {
		E771_Jewels_and_Stones solution = new E771_Jewels_and_Stones();
		String input = "aA", stones = "aAAbbbb";
		int output = solution.numJewelsInStones(input, stones);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public int numJewelsInStones(String jewels, String stones) {
		Set<Character> jewelSet = new HashSet<>();
		
		for (char c : jewels.toCharArray()) {
			jewelSet.add(c);
		}
		
		int count = 0;
		for (char c : stones.toCharArray()) {
			if (jewelSet.contains(c)) {
				count++;
			}
		}
		
		return count;
	}

}
