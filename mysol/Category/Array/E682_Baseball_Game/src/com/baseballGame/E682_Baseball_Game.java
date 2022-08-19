package com.baseballGame;
import java.util.*;

/*
You are keeping score for a baseball game with strange rules. 
The game consists of several rounds, where the scores of past 
rounds may affect future rounds' scores.

At the beginning of the game, you start with an empty record. 
You are given a list of strings ops, where ops[i] is the ith 
operation you must apply to the record and is one of the following:

1. An integer x - Record a new score of x.
2. "+" - Record a new score that is the sum of the previous two scores. 
	It is guaranteed there will always be two previous scores.
3. "D" - Record a new score that is double the previous score. 
	It is guaranteed there will always be a previous score.
4. "C" - Invalidate the previous score, removing it from the record. 
	It is guaranteed there will always be a previous score.

Return the sum of all the scores on the record. The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:

Input: ops = ["5","2","C","D","+"]
Output: 30
Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.

Example 2:

Input: ops = ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation:
"5" - Add 5 to the record, record is now [5].
"-2" - Add -2 to the record, record is now [5, -2].
"4" - Add 4 to the record, record is now [5, -2, 4].
"C" - Invalidate and remove the previous score, record is now [5, -2].
"D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
"9" - Add 9 to the record, record is now [5, -2, -4, 9].
"+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
"+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.

Example 3:

Input: ops = ["1","C"]
Output: 0
Explanation:
"1" - Add 1 to the record, record is now [1].
"C" - Invalidate and remove the previous score, record is now [].
Since the record is empty, the total sum is 0.
*/

public class E682_Baseball_Game {

	public static void main(String[] args) {
		String[] input = {"5","2","C","D","+"};
        int output = calPoints(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    用数组保存分数，按照题意模拟即可
    */
	
	/**
     * @param ops: the list of operations
     * @return:  the sum of the points you could get in all the rounds
     */
	public static int calPoints(String[] ops) {
		int[] ar = new int[ops.length];
        int pointer=-1, sum=0;
        for(String st: ops){
            char c = st.charAt(0);
            if (c == '+') {
                sum += (ar[++pointer] = ar[pointer-1] + ar[pointer-2]);
            }
            else if (c== 'D') {
                sum += (ar[++pointer] = 2 * ar[pointer-1]);
            }
            else if (c=='C') {
                sum -= ar[pointer--];
            }
            else {
                sum += (ar[++pointer] = Integer.parseInt(st));
            }
        }
        return sum;
	}

}
