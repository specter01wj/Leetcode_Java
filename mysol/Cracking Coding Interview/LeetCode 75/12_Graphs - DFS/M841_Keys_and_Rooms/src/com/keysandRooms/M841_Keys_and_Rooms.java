package com.keysandRooms;
import java.util.*;

/*
There are n rooms labeled from 0 to n - 1 and all the rooms are 
locked except for room 0. Your goal is to visit all the rooms. 
However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. 
Each key has a number on it, denoting which room it unlocks, and 
you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you 
can obtain if you visited room i, return true if you can visit 
all the rooms, or false otherwise.
*/

public class M841_Keys_and_Rooms {

	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<>();
		input.add(new ArrayList<>(Arrays.asList(1)));
		input.add(new ArrayList<>(Arrays.asList(2)));
		input.add(new ArrayList<>(Arrays.asList(3)));
		input.add(new ArrayList<>());   
		boolean output = canVisitAllRooms(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    DFS
    */
	
	/*
     * @param rooms: a list of integers
     * @return: true if you can visit all the rooms, or false otherwise
     */
	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Set to keep track of visited rooms
        Set<Integer> visited = new HashSet<>();

        // Start DFS from room 0
        dfs(0, rooms, visited);

        // Check if the number of visited rooms is equal to the total number of rooms
        return visited.size() == rooms.size();
    }

    private static void dfs(int room, List<List<Integer>> rooms, Set<Integer> visited) {
        // Mark the current room as visited
        visited.add(room);

        // Go through all the keys in the current room
        for (int key : rooms.get(room)) {
            // If the room has not been visited yet, visit it
            if (!visited.contains(key)) {
                dfs(key, rooms, visited);
            }
        }
    }

}
