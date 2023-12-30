package com.asteroidCollision;
import java.util.*;

/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign 
represents its direction (positive meaning right, negative meaning left). 
Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. 
If two asteroids meet, the smaller one will explode. 
If both are the same size, both will explode. 
Two asteroids moving in the same direction will never meet.
*/

public class M735_Asteroid_Collision {

	public static void main(String[] args) {
		int[] input = {5,10,-5};
        int[] output = asteroidCollision(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    Stack
    */
	
	/*
     * @param asteroids: a list of integers
     * @return: the state of the asteroids after all collisions
     */
	public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            collision:
            {
                while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                    if (stack.peek() < -ast) {
                        // The current asteroid is larger; pop the stack
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        // Both asteroids are of the same size; both explode
                        stack.pop();
                    }
                    // Current asteroid explodes or both are same size
                    break collision;
                }
                // No collision or current asteroid is larger
                stack.push(ast);
            }
        }

        // Convert the stack to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

}
