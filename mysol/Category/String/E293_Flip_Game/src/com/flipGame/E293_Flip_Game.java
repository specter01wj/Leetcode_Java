package com.flipGame;
import java.util.*;

/*You are playing the following Flip Game with your friend: 
Given a string that contains only these two characters: + and -, 
you and your friend take turns to flip two consecutive "++" into "--". 
The game ends when a person can no longer make a move and therefore 
the other person will be the winner.

Write a function to compute all possible states of the string 
after one valid move.

Example:

Input: s = "++++"
Output: 
[
  "--++",
  "+--+",
  "++--"
]*/

public class E293_Flip_Game {

	public static void main(String[] args) {
		String input = "++++";//"++++";
        List<String> output = generatePossibleNextMoves(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    枚举所有的++所在位置，将其替换成--后加入到答案中
    */
	
	/**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
	public static List<String> generatePossibleNextMoves(String s) {
		List list = new ArrayList();
		
		for(int i = -1; (i = s.indexOf("++", i + 1)) >= 0;) {
			list.add(s.substring(0, i) + "--" + s.substring(i + 2));
		}
		
		return list;
	}

}
