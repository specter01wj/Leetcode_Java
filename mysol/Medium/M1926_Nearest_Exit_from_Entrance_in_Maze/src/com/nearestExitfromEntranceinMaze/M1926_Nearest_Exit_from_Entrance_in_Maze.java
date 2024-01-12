package com.nearestExitfromEntranceinMaze;
import java.util.*;

/*
You are given an m x n matrix maze (0-indexed) with empty cells 
(represented as '.') and walls (represented as '+'). 
You are also given the entrance of the maze, where entrance = 
[entrancerow, entrancecol] denotes the row and column of the 
cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. 
You cannot step into a cell with a wall, and you cannot step 
outside the maze. Your goal is to find the nearest exit from 
the entrance. An exit is defined as an empty cell that is at 
the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance 
to the nearest exit, or -1 if no such path exists.
*/

public class M1926_Nearest_Exit_from_Entrance_in_Maze {

	public static void main(String[] args) {
		char[][] input = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
		int[] entrance = {1,2};
		int output = nearestExit(input, entrance);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    BFS
    */
	
	/*
     * @param maze: a list of 2D strings
     * @param entrance: a list of integers
     * @return: the number of steps in the shortest path from the entrance to the nearest exit
     */
	public static int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        maze[entrance[0]][entrance[1]] = '+'; // Mark the entrance as visited
        queue.offer(new int[]{entrance[0], entrance[1], 0}); // Add entrance to queue

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i], newY = y + dy[i];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == '.') {
                    if (newX == 0 || newX == m - 1 || newY == 0 || newY == n - 1) {
                        return dist + 1; // Found an exit
                    }
                    maze[newX][newY] = '+'; // Mark as visited
                    queue.offer(new int[]{newX, newY, dist + 1});
                }
            }
        }
        return -1; // No exit found
    }

}
