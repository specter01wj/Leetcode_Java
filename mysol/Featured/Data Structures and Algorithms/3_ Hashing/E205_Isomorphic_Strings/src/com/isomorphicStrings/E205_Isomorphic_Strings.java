package com.isomorphicStrings;
import java.util.*;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character 
while preserving the order of characters. No two characters may map to 
the same character, but a character may map to itself.
*/

public class E205_Isomorphic_Strings {

	public static void main(String[] args) {
		E205_Isomorphic_Strings solution = new E205_Isomorphic_Strings();
		String input = "egg", t = "add";
		boolean output = solution.isIsomorphic(input, t);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param s: a string
     * @param t: a string
     * @return: determine if they are isomorphic
     */
	public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (mapST.containsKey(sc)) {
                if (mapST.get(sc) != tc) return false;
            } else {
                mapST.put(sc, tc);
            }

            if (mapTS.containsKey(tc)) {
                if (mapTS.get(tc) != sc) return false;
            } else {
                mapTS.put(tc, sc);
            }
        }

        return true;
    }

}
