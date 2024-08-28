package com.checkDistancesBetweenSameLetters;
import java.util.*;

/*
You are given a 0-indexed string s consisting of only lowercase 
English letters, where each letter in s appears exactly twice. 
You are also given a 0-indexed integer array distance of length 26.

Each letter in the alphabet is numbered from 0 to 25 
(i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, ... , 'z' -> 25).

In a well-spaced string, the number of letters between the 
two occurrences of the ith letter is distance[i]. If the ith 
letter does not appear in s, then distance[i] can be ignored.

Return true if s is a well-spaced string, otherwise return false.
*/

public class E2399_Check_Distances_Between_Same_Letters {

	public static void main(String[] args) {
		E2399_Check_Distances_Between_Same_Letters solution = new E2399_Check_Distances_Between_Same_Letters();
		String input = "abaccb";
		int[] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		boolean output = solution.checkDistances(input, distance);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public boolean checkDistances(String s, int[] distance) {
        // Array to store the first occurrence of each letter
        int[] firstOccurrence = new int[26];
        // Initialize all values to -1 to indicate that no letter has been seen yet
        for (int i = 0; i < 26; i++) {
            firstOccurrence[i] = -1;
        }

        // Loop through the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a'; // Calculate the index of the letter in the alphabet

            if (firstOccurrence[index] == -1) {
                // If this is the first occurrence of the letter, store the index
                firstOccurrence[index] = i;
            } else {
                // If this is the second occurrence, calculate the distance
                int actualDistance = i - firstOccurrence[index] - 1;
                if (actualDistance != distance[index]) {
                    // If the distance doesn't match the expected distance, return false
                    return false;
                }
            }
        }

        // If all letters satisfy the distance requirement, return true
        return true;
    }

}
