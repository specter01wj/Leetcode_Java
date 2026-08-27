package com.jinwang;

import java.util.Stack;

public class M2434_Using_A_Robot_To_Print_The_Lexicographically_Smallest_String {

	public static void main(String[] args) {
		M2434_Using_A_Robot_To_Print_The_Lexicographically_Smallest_String solution =
				new M2434_Using_A_Robot_To_Print_The_Lexicographically_Smallest_String();

		// Example 1
		String s1 = "zza";

		System.out.println("Input: " + s1);
		System.out.println("Output: " + solution.robotWithString(s1));
		System.out.println();

		// Example 2
		String s2 = "bac";

		System.out.println("Input: " + s2);
		System.out.println("Output: " + solution.robotWithString(s2));
		System.out.println();

		// Example 3
		String s3 = "bdda";

		System.out.println("Input: " + s3);
		System.out.println("Output: " + solution.robotWithString(s3));
	}
	
	public String robotWithString(String s) {
		int[] count = new int[26];

		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		Stack<Character> stack = new Stack<>();
		StringBuilder answer = new StringBuilder();

		char smallest = 'a';

		for (char c : s.toCharArray()) {
			stack.push(c);
			count[c - 'a']--;

			// Find the smallest remaining character in s
			while (smallest <= 'z' && count[smallest - 'a'] == 0) {
				smallest++;
			}

			// Output characters that are no larger than the smallest remaining character
			while (!stack.isEmpty()
					&& (smallest > 'z' || stack.peek() <= smallest)) {
				answer.append(stack.pop());
			}
		}

		return answer.toString();
	}

}
