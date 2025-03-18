package com.snakeinMatrix;
import java.util.*;

/*
There is a snake in an n x n matrix grid and can move in four 
possible directions. Each cell in the grid is identified by 
the position: grid[i][j] = (i * n) + j.

The snake starts at cell 0 and follows a sequence of commands.

You are given an integer n representing the size of the grid and 
an array of strings commands where each command[i] is either "UP", 
"RIGHT", "DOWN", and "LEFT". It's guaranteed that the snake will 
remain within the grid boundaries throughout its movement.

Return the position of the final cell where the snake ends up after 
executing commands.
*/

public class E3248_Snake_in_Matrix {

	public static void main(String[] args) {
		E3248_Snake_in_Matrix solution = new E3248_Snake_in_Matrix();
		int input = 2;
		List<String> commands = List.of("RIGHT","DOWN");
		int output = solution.finalPositionOfSnake(input, commands);
        System.out.println("input: " + (commands) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. The snake starts at position (0,0) in the matrix.
	2. We iterate through the commands list and update the row and col values accordingly.
	3. At the end, the final position (row, col) is converted to a 1D index using the formula: index=(row×n)+col
	4. The output is the final index of the snake after executing all commands.
    */
	
	/*
     * @param n: an integer
     * @param commands: a list of strings
     * @return: the position of the final cell where the snake ends up after executing commands
     */
	public int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0, col = 0; // The snake starts at position (0,0)
        
        for (String command : commands) {
            switch (command) {
                case "UP":
                    row -= 1;
                    break;
                case "DOWN":
                    row += 1;
                    break;
                case "LEFT":
                    col -= 1;
                    break;
                case "RIGHT":
                    col += 1;
                    break;
            }
        }
        
        // Convert (row, col) position to 1D index
        return (row * n) + col;
    }

}
