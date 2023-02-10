package com.finalValueofVariableAfterPerformingOperations;
import java.util.*;

/*
There is a programming language with only four operations and one variable X:

	.++X and X++ increments the value of the variable X by 1.
	.--X and X-- decrements the value of the variable X by 1.

Initially, the value of X is 0.

Given an array of strings operations containing a list of operations, 
return the final value of X after performing all the operations.


Example 1:

Input: operations = ["--X","X++","X++"]
Output: 1
Explanation: The operations are performed as follows:
Initially, X = 0.
--X: X is decremented by 1, X =  0 - 1 = -1.
X++: X is incremented by 1, X = -1 + 1 =  0.
X++: X is incremented by 1, X =  0 + 1 =  1.

Example 2:

Input: operations = ["++X","++X","X++"]
Output: 3
Explanation: The operations are performed as follows:
Initially, X = 0.
++X: X is incremented by 1, X = 0 + 1 = 1.
++X: X is incremented by 1, X = 1 + 1 = 2.
X++: X is incremented by 1, X = 2 + 1 = 3.

Example 3:

Input: operations = ["X++","++X","--X","X--"]
Output: 0
Explanation: The operations are performed as follows:
Initially, X = 0.
X++: X is incremented by 1, X = 0 + 1 = 1.
++X: X is incremented by 1, X = 1 + 1 = 2.
--X: X is decremented by 1, X = 2 - 1 = 1.
X--: X is decremented by 1, X = 1 - 1 = 0.
*/

public class E2011_Final_Value_of_Variable_After_Performing_Operations {

	public static void main(String[] args) {
		String[] input = {"--X","X++","X++"};
        int output = finalValueAfterOperations(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int finalValueAfterOperations(String[] operations) {
        int val = 0;
    	for (int i = 0;i < operations.length;i++) {
    		if (operations[i].charAt(1) == '+') {
                val++;
            } else {
                val--;
            }
    	}
    	return val; 
    }

}
