package com.makeaSquarewiththeSameColor;
import java.util.*;

/*
You are given a 2D matrix grid of size 3 x 3 consisting only of 
characters 'B' and 'W'. Character 'W' represents the white color, 
and character 'B' represents the black color.

Your task is to change the color of at most one cell so that the 
matrix has a 2 x 2 square where all cells are of the same color.

Return true if it is possible to create a 2 x 2 square of the 
same color, otherwise, return false.
*/

public class E3127_Make_a_Square_with_the_Same_Color {

	public static void main(String[] args) {
		E3127_Make_a_Square_with_the_Same_Color solution = new E3127_Make_a_Square_with_the_Same_Color();
		char[][] input = {{'B','W','B'},{'B','W','W'},{'B','W','B'}};
		boolean output = solution.canMakeSquare(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public boolean canMakeSquare(char[][] grid) {
        // Loop through all possible 2x2 squares in the 3x3 grid
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                // Count the occurrences of 'B' and 'W' in the current 2x2 square
                int countB = 0;
                int countW = 0;

                for (int x = i; x < i + 2; x++) {
                    for (int y = j; y < j + 2; y++) {
                        if (grid[x][y] == 'B') {
                            countB++;
                        } else {
                            countW++;
                        }
                    }
                }

                // Check if the current 2x2 square can be made uniform by changing at most one cell
                if (countB >= 3 || countW >= 3) {
                    return true;
                }
            }
        }

        return false;
    }

}
