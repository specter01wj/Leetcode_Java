package com.findWinneronaTicTacToeGame;
import java.util.*;

/*
Tic-tac-toe is played by two players A and B on a 3 x 3 grid. 
The rules of Tic-Tac-Toe are:

. Players take turns placing characters into empty squares ' '.
. The first player A always places 'X' characters, 
  while the second player B always places 'O' characters.
. 'X' and 'O' characters are always placed into empty squares, never on filled ones.
. The game ends when there are three of the same (non-empty) character filling any row, 
  column, or diagonal.
. The game also ends if all squares are non-empty.
. No more moves can be played if the game is over.

Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that 
the ith move will be played on grid[rowi][coli]. 
return the winner of the game if it exists (A or B). 
In case the game ends in a draw return "Draw". If there are still movements to 
play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), 
the grid is initially empty, and A will play first.


Example 1:

Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.

Example 2:

Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: B wins.

Example 3:

Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
*/

public class E1275_Find_Winner_on_a_Tic_Tac_Toe_Game {

	public static void main(String[] args) {
		int[][] input = {{0,0},{2,0},{1,1},{2,1},{2,2}};
		String output = tictactoe(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Totally 8 ways to win: placement of 3 same characters on:
	1. 3 rows;
	2. 3 cols;
	3. 2 diagonals.
	Therefore we can use arrays of size 3 to accumulate the count of same characters on rows 
	and cols; use int variables to accumulate the count of same characters on diagonals.
	
	id: 0 for A, 1 for B;
	row[id][r]: the current number of characters that player id places on row r;
	col[id][c]: the current number of characters that player id places on column c;
	d1[id]: the current number of characters that player id places on main diagonal;
	d2[id]: the current number of characters that player id places on skew diagonal.
    */
	
	/*
     * @param prices: a list of 2D integer
     * @return: the winner of the game if it exists (A or B)
     */
	public static String tictactoe(int[][] moves) {
        int[][] row = new int[2][3], col = new int[2][3];
        int[] d1 = new int[2], d2 = new int[2];
        for (int i = 0; i < moves.length; ++i) {
            int r = moves[i][0], c = moves[i][1], id = i % 2;
            if (++row[id][r] == 3 || ++col[id][c] == 3 || r == c && ++d1[id] == 3 || r + c == 2 && ++d2[id] == 3) {
                return id == 0 ? "A" : "B";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";   
    }

}
