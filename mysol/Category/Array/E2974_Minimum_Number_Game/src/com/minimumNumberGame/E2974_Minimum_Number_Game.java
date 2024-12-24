package com.minimumNumberGame;
import java.util.*;

/*
You are given a 0-indexed integer array nums of even length and there is 
also an empty array arr. Alice and Bob decided to play a game where in 
every round Alice and Bob will do one move. 
The rules of the game are as follows:

	. Every round, first Alice will remove the minimum element from nums, and then Bob does the same.
	. Now, first Bob will append the removed element in the array arr, and then Alice does the same.
	. The game continues until nums becomes empty.

Return the resulting array arr.
*/

public class E2974_Minimum_Number_Game {

	public static void main(String[] args) {
		E2974_Minimum_Number_Game solution = new E2974_Minimum_Number_Game();
		int[] input = {5,4,2,3};
		int[] output = solution.numberGame(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] numberGame(int[] nums) {
        // Sort the array to handle minimum elements
        Arrays.sort(nums);

        // Use a LinkedList to efficiently handle removing elements from the front
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Result array to store the output
        int[] arr = new int[nums.length];
        int index = 0;

        // Simulate the game
        while (!list.isEmpty()) {
            // Alice removes the minimum element
            int alice = list.pollFirst();

            // Bob removes the minimum element
            int bob = list.pollFirst();

            // Bob appends to the array first, then Alice
            arr[index++] = bob;
            arr[index++] = alice;
        }

        return arr;
    }

}
