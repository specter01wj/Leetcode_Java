package com.jinwang;

import java.util.LinkedList;
import java.util.Queue;

public class M649_Dota2_Senate {

	public static void main(String[] args) {
		M649_Dota2_Senate solution = new M649_Dota2_Senate();

		// Example 1
		String senate1 = "RD";

		System.out.println("Input: " + senate1);
		System.out.println("Output: " + solution.predictPartyVictory(senate1));
		System.out.println();

		// Example 2
		String senate2 = "RDD";

		System.out.println("Input: " + senate2);
		System.out.println("Output: " + solution.predictPartyVictory(senate2));
	}
	
	public String predictPartyVictory(String senate) {
		Queue<Integer> radiant = new LinkedList<>();
		Queue<Integer> dire = new LinkedList<>();

		int n = senate.length();

		// Store each senator's position
		for (int i = 0; i < n; i++) {
			if (senate.charAt(i) == 'R') {
				radiant.offer(i);
			} else {
				dire.offer(i);
			}
		}

		while (!radiant.isEmpty() && !dire.isEmpty()) {
			int r = radiant.poll();
			int d = dire.poll();

			// Whoever comes first bans the other
			if (r < d) {
				radiant.offer(r + n);
			} else {
				dire.offer(d + n);
			}
		}

		return radiant.isEmpty() ? "Dire" : "Radiant";
	}

}
