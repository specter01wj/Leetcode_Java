package com.jinwang;

import java.util.Arrays;
import java.util.Stack;

public class M735_Asteroid_Collision {

	public static void main(String[] args) {
		M735_Asteroid_Collision solution = new M735_Asteroid_Collision();

		// Example 1
		int[] asteroids1 = {5, 10, -5};

		System.out.println("Input: " + Arrays.toString(asteroids1));
		System.out.println("Output: "
				+ Arrays.toString(solution.asteroidCollision(asteroids1)));
		System.out.println();

		// Example 2
		int[] asteroids2 = {8, -8};

		System.out.println("Input: " + Arrays.toString(asteroids2));
		System.out.println("Output: "
				+ Arrays.toString(solution.asteroidCollision(asteroids2)));
		System.out.println();

		// Example 3
		int[] asteroids3 = {10, 2, -5};

		System.out.println("Input: " + Arrays.toString(asteroids3));
		System.out.println("Output: "
				+ Arrays.toString(solution.asteroidCollision(asteroids3)));
		System.out.println();

		// Example 4
		int[] asteroids4 = {3, 5, -6, 2, -1, 4};

		System.out.println("Input: " + Arrays.toString(asteroids4));
		System.out.println("Output: "
				+ Arrays.toString(solution.asteroidCollision(asteroids4)));
	}
	
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();

		for (int asteroid : asteroids) {
			boolean destroyed = false;

			// Collision only happens when stack top moves right
			// and current asteroid moves left
			while (!stack.isEmpty()
					&& stack.peek() > 0
					&& asteroid < 0) {

				if (stack.peek() < -asteroid) {
					stack.pop();
				} else if (stack.peek() == -asteroid) {
					stack.pop();
					destroyed = true;
					break;
				} else {
					destroyed = true;
					break;
				}
			}

			if (!destroyed) {
				stack.push(asteroid);
			}
		}

		int[] answer = new int[stack.size()];

		for (int i = answer.length - 1; i >= 0; i--) {
			answer[i] = stack.pop();
		}

		return answer;
	}

}
