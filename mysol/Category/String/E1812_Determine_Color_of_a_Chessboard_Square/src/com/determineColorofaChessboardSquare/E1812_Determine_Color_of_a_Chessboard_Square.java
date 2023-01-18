package com.determineColorofaChessboardSquare;
import java.util.*;

/*
You are given coordinates, a string that represents the coordinates of 
a square of the chessboard. Below is a chessboard for your reference.

Return true if the square is white, and false if the square is black.

The coordinate will always represent a valid chessboard square. 
The coordinate will always have the letter first, and the number second.


Example 1:

Input: coordinates = "a1"
Output: false
Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.

Example 2:

Input: coordinates = "h3"
Output: true
Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.

Example 3:

Input: coordinates = "c7"
Output: false
*/

public class E1812_Determine_Color_of_a_Chessboard_Square {

	public static void main(String[] args) {
		String input = "a1";
        boolean output = squareIsWhite(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    sum of the alphabet and number is always even in black board and odd in white board.
    */
	
	/**
     * @param coordinates: a string
     * @return: true if the square is white, and false if the square is black
     */
	public static boolean squareIsWhite(String coordinates) {
       return coordinates.charAt(0) % 2 != coordinates.charAt(1) % 2; 
    }

}
