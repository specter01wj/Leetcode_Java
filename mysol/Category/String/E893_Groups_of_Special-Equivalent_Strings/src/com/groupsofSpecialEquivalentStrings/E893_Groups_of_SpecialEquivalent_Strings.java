package com.groupsofSpecialEquivalentStrings;
import java.util.*;

/*You are given an array A of strings.

A move onto S consists of swapping any two even indexed characters of S, 
or any two odd indexed characters of S.

Two strings S and T are special-equivalent if after any number of moves 
onto S, S == T.

For example, S = "zzxy" and T = "xyzz" are special-equivalent because 
we may make the moves "zzxy" -> "xzzy" -> "xyzz" that swap S[0] and S[2], 
then S[1] and S[3].

Now, a group of special-equivalent strings from A is a non-empty subset 
of A such that:

1. Every pair of strings in the group are special equivalent, and;
2. The group is the largest size possible (ie., there isn't a string S not 
in the group such that S is special equivalent to every string in the group)

Return the number of groups of special-equivalent strings from A.

 
Example 1:

Input: ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
Output: 3
Explanation: 
One group is ["abcd", "cdab", "cbad"], since they are all pairwise special 
equivalent, and none of the other strings are all pairwise special 
equivalent to these.

The other two groups are ["xyzz", "zzxy"] and ["zzyx"].  Note that in 
particular, "zzxy" is not special equivalent to "zzyx".

Example 2:

Input: ["abc","acb","bac","bca","cab","cba"]
Output: 3*/

public class E893_Groups_of_SpecialEquivalent_Strings {

	public static void main(String[] args) {
		String[] input = {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        int output = numSpecialEquivGroups(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    For each String, we generate it's corresponding signature, 
    and add it to the set.
	In the end, we return the size of the set.
    */
	
	/**
     * @param A: a string array
     * @return: Return the number of groups of special-equivalent strings from A.
     */
	public static int numSpecialEquivGroups(String[] A) {
		Set<String> s = new HashSet();
		
		for(String str : A) {
			int[] count = new int[52];
			for(int i = 0; i < str.length(); ++i) {
				count[str.charAt(i) - 'a' + 26 * (i % 2)]++;
			}
			
			
			
			
			
			
			
			s.add(Arrays.toString(count));
		}
		
		return s.size();
	}

}
